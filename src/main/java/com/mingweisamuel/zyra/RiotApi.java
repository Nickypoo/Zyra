package com.mingweisamuel.zyra;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.util.Lazy;
import com.mingweisamuel.zyra.util.RateLimitedRequester;
import com.mingweisamuel.zyra.util.RateLimiter;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Param;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API. The main class for interacting with the Riot API on a low level.<br><br>
 *
 * The {@link com.mingweisamuel.zyra.entity.EntityApi} is simpler and more user-friendly to use.
 */
public class RiotApi implements Closeable {

    /** Json parser. */
    private final Gson gson = new Gson();
    /** Web requester. */
    private final Lazy<RateLimitedRequester> requester;

    public final ChampionEndpoints champions = new ChampionEndpoints(this);
    public final ChampionMasteryEndpoints championMasteries = new ChampionMasteryEndpoints(this);
    public final LeagueEndpoints leagues = new LeagueEndpoints(this);
    public final SpectatorEndpoints spectator = new SpectatorEndpoints(this);
    public final LolStaticDataEndpoints staticData = new LolStaticDataEndpoints(this);
    public final LolStatusEndpoints status = new LolStatusEndpoints(this);
    public final MasteriesEndpoints masteries = new MasteriesEndpoints(this);
    public final MatchEndpoints matches = new MatchEndpoints(this);
    public final RunesEndpoints runes = new RunesEndpoints(this);
    public final SummonerEndpoints summoners = new SummonerEndpoints(this);


    /**
     * Creates a RiotApi.Builder with default development rate limits (10 requests per 10 seconds, 500 requests
     * per 10 minutes).
     *
     * @param apiKey Development API key.
     * @return Builder instance. Call {@link Builder#build()} to get RiotApi instance.
     */
    public static Builder builder(String apiKey) {
        return new Builder(apiKey);
    }

    /**
     * Creates a RiotApi.Builder with default production rate limits (3,000 requests per 10 seconds, 180,000 requests
     * per 10 minutes).
     *
     * @param apiKey Production API key.
     * @return Builder instance. Call {@link Builder#build()} to get RiotApi instance.
     */
    public static Builder productionBuilder(String apiKey) {
        return new Builder(apiKey).setDefaultRateLimits(true)
            .setConcurrentRequestsMax(RateLimiter.CONCURRENT_REQUESTS_PRODUCTION_MAX)
            .setTemporalResolutionFactor(10) // 3000 req/10 sec => 300 req/sec.
            .setRateLimitOverheadFactor(0.95f); // actually just 95% * 300 => 285 req/sec.
    }

    /** Riot API builder for obtaining instances of the Riot API. */
    public static class Builder {

        /** Riot Games API key. */
        private final String apiKey;

        /** API rate limits. Key is time span in milliseconds, value is max number of requests allowed during that
         * timespan. */
        private Map<Long, Integer> rateLimits = new HashMap<>();
        {
            rateLimits.put(RateLimitedRequester.TEN_SECONDS, 10);
            rateLimits.put(RateLimitedRequester.TEN_MINUTES, 500);
        }

        /** The number of times to retry a request. */
        private int retries = RateLimitedRequester.RETRIES_DEFAULT;

        /** The number of concurrent requests allowed (per-region). */
        private int concurrentRequestsMax = RateLimiter.CONCURRENT_REQUESTS_DEFAULT_MAX;

        /** AsyncHttpClient to use. Null for default client. */
        private AsyncHttpClient client = null;

        /** Multiplier of the rate limit to prevent excessive rate limit violations. */
        private float rateLimitOverheadFactor = 1;

        /** Rate limit divisor for running concurrent API instances. */
        private int concurrentInstances = 1;

        /**
         * Multiplier of temporal resolution. If this has value 10, then a rate limit of 3000 req/10 sec
         * will be treated as a rate limit of 300 req/sec.
         */
        private float temporalResolutionFactor = 1;

        /** Listener for HTTP responses. */
        private ResponseListener responseListener = null;


        /**
         * Creates a builder for a RiotApi instance with the specified API key.
         *
         * The rate limits default to the standard development api key rate limits. 10 requests every 10 seconds, 500
         * requests every ten minutes.
         *
         * @param apiKey Riot Games API Key. Go <a href="https://developer.riotgames.com/">here</a> to obtain a key.
         */
        private Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        /**
         * Builds the RiotApi instance. Returns a new instances every time this method is called.
         * @return RiotApi instance.
         */
        public RiotApi build() {
            if (client == null) {
                client = new DefaultAsyncHttpClient(
                    new DefaultAsyncHttpClientConfig.Builder().setThreadFactory(
                        new ThreadFactoryBuilder().setDaemon(true).build()).build());
            }
            Map<Long, Integer> calculatedRateLimits = new HashMap<>();
            for (Map.Entry<Long, Integer> rateLimit : rateLimits.entrySet()) {
                calculatedRateLimits.put((long) Math.ceil(rateLimit.getKey() / temporalResolutionFactor),
                    (int) Math.floor(rateLimitOverheadFactor * rateLimit.getValue() /
                        (temporalResolutionFactor * concurrentInstances)));
            }
            return new RiotApi(apiKey, calculatedRateLimits, client, retries, concurrentRequestsMax, responseListener);
        }

        /**
         * Set arbitrary rate limits.
         * @param rateLimits Map from long representing time span in milliseconds to int max requests per that time
         *                   span.
         * @return This, for chaining.
         */
        public Builder setRateLimits(Map<Long, Integer> rateLimits) {
            this.rateLimits = rateLimits;
            return this;
        }

        /**
         * Sets max requests per 10 seconds and 10 minutes rate limits.
         * @param rateLimitPer10Seconds Requests per 10 seconds.
         * @param rateLimitPer10Minutes Requests per 10 minutes.
         * @return This, for chaining.
         */
        public Builder setRateLimits(int rateLimitPer10Seconds, int rateLimitPer10Minutes) {
            rateLimits = new HashMap<>();
            rateLimits.put(RateLimitedRequester.TEN_SECONDS, rateLimitPer10Seconds);
            rateLimits.put(RateLimitedRequester.TEN_MINUTES, rateLimitPer10Minutes);
            return this;
        }

        /**
         * Set the rate limits to either default development rate limits (10 requests per 10 seconds, 500 requests
         * per 10 minutes) or default production rate limits (3,000 requests per 10 seconds, 180,000 requests per
         * 10 minutes).
         *
         * @param production If true, set to default production rate limits. If false, set to default development
         *                   rate limits.
         * @return This, for chaining.
         */
        public Builder setDefaultRateLimits(boolean production) {
            rateLimits = new HashMap<>();
            if (production) {
                rateLimits.put(RateLimitedRequester.TEN_SECONDS, 3_000);
                rateLimits.put(RateLimitedRequester.TEN_MINUTES, 180_000);
            }
            else {
                rateLimits.put(RateLimitedRequester.TEN_SECONDS, 10);
                rateLimits.put(RateLimitedRequester.TEN_MINUTES, 500);
            }
            return this;
        }

        /**
         * Set times to retry failed requests.
         * @param retries
         * @return This, for chaining.
         */
        public Builder setRetries(int retries) {
            this.retries = retries;
            return this;
        }

        /**
         * Set the maximum number of concurrent requests allowed per region.
         * @param concurrentRequestsMax
         * @return This, for chaining.
         */
        public Builder setConcurrentRequestsMax(int concurrentRequestsMax) {
            this.concurrentRequestsMax = concurrentRequestsMax;
            return this;
        }

        /**
         * Sets the AsyncHttpClient to use.
         * @param client
         * @return This, for chaining.
         */
        public Builder setClient(AsyncHttpClient client) {
            this.client = client;
            return this;
        }

        /**
         * Sets a overhead factor for the rate limit. For example, if 0.9 is used, the API will limit requests rate
         * to 90% of the full rate limit. This is to prevent accidental rate limit violations.
         * @param rateLimitOverheadFactor Rate limit overhead factor (0.9 -&gt; 90% of rate limit).
         * @return This, for chaining.
         */
        public Builder setRateLimitOverheadFactor(float rateLimitOverheadFactor) {
            this.rateLimitOverheadFactor = rateLimitOverheadFactor;
            return this;
        }

        /**
         * Sets a multiplier of temporal resolution. For example, if this has value 10, then a production rate limit of
         * 3000 req/10 sec would be treated as a rate limit of 300 req/sec. This spreads out requests more and helps
         * prevent accidental rate limit violations.
         * @param temporalResolutionFactor Factor to multiply temporal resolution by. Should be greater than zero to
         *     prevent violations (not enforced). Must be positive.
         * @return This, for chaining.
         */
        public Builder setTemporalResolutionFactor(float temporalResolutionFactor) {
            if (temporalResolutionFactor <= 0)
                throw new IllegalArgumentException(
                    "Temporal resolution factor must be positive: " + temporalResolutionFactor);
            this.temporalResolutionFactor = temporalResolutionFactor;
            return this;
        }

        /**
         * Treats the created instance as one of many parallel instances and divides rate limits appropriately.
         * @param instances Number of parallel instances.
         * @return This, for chaining.
         */
        public Builder setConcurrentInstances(int instances) {
            if (instances <= 0)
                throw new IllegalArgumentException("Instances must be greater than 0: " + instances);
            this.concurrentInstances = instances;
            return this;
        }

        /**
         * Sets a response listener to listen to HTTP responses.
         * @param responseListener A response listener. Set to {@code null} to clear response listener.
         * @return This, for chaining.
         * @deprecated TODO: This logic will change form in the near future.
         */
        @Deprecated
        public Builder setResponseListener(ResponseListener responseListener) {
            this.responseListener = responseListener;
            return this;
        }
    }

    /**
     * Creates a RiotApi instance.
     *
     * @param apiKey Riot Games API key.
     * @param rateLimits
     * @param client AsyncHttpClient
     * @param retries
     * @param maxConcurrentRequests
     */
    private RiotApi(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client, int retries,
            int maxConcurrentRequests, ResponseListener responseListener) {
        requester = new Lazy<>(() ->
            new RateLimitedRequester(apiKey, rateLimits, client, retries, maxConcurrentRequests, responseListener));
    }

    /**
     * Standardizes the supplied summoner name by removing whitespace and converting all uppercase letters to lowercase.
     * @param name Summoner name.
     * @return Standardized summoner name.
     */
    public static String standardizeName(String name) {
        return name.replaceAll("\\s", "").toLowerCase();
    }

    @Override
    public void close() throws IOException {
        requester.get().close(); // May create the requester to immediately close it.
    }

    //region util
    <T> T getBasic(String url, Region region, Type type, List<Param> params) {
        return this.<T>getBasicAsync(url, region, type, params).join();
    }

    <T> CompletableFuture<T> getBasicAsync(String url, Region region, Type type, List<Param> params) {
        return requester.get().getRequestRateLimitedAsync(url, region, params)
                .thenApply(r -> r.getStatusCode() != 200 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    <T> T getBasicNonRateLimited(String url, Region region, Type type, List<Param> params) {
        return this.<T>getBasicNonRateLimitedAsync(url, region, type, params).join();
    }

    <T> CompletableFuture<T> getBasicNonRateLimitedAsync(String url, Region region, Type type, List<Param> params) {
        return requester.get().getRequestNonRateLimitedAsync(url, region, params)
                .thenApply(r -> r.getStatusCode() != 200 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    <T> T getNonApi(String fullUrl, Type type, List<Param> params) {
        return this.<T>getNonApiAsync(fullUrl, type, params).join();
    }

    <T> CompletableFuture<T> getNonApiAsync(String fullUrl, Type type, List<Param> params) {
        return requester.get().getRequestAsync(fullUrl, "", params)
                .thenApply(r -> gson.fromJson(r.getResponseBody(), type));
    }
    //endregion

    /**
     * Creates params from each pair of elements. Must be an even number of elements. Key values must be non-null.
     * @param paired
     * @return
     */
    List<Param> makeParams(Object... paired) {

        ArrayList<Param> result = new ArrayList<>(paired.length / 2);
        for (int i = 0; i < paired.length; i += 2) {

            Object key = paired[i];
            if (key == null)
                throw new IllegalStateException("Cannot have null param key");

            Object value = paired[i + 1];
            if (value == null)
                continue;

            if (value instanceof Collection) {
                for (Object v : ((Collection<?>) value))
                    result.add(new Param(key.toString(), v.toString()));
            }
            else
                result.add(new Param(key.toString(), value.toString()));
        }
        return result;
    }
    //endregion
}
