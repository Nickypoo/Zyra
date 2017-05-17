package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.spectator.FeaturedGames;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * spectator-v3
 * This class is automatically generated and should not be modified directly.
 */
public final class SpectatorEndpoints extends Endpoints {
  SpectatorEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) The ID of the summoner.
   */
  public CurrentGameInfo getCurrentGameInfoBySummoner(final Region region, final long summonerId)
      throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v3/active-games/by-summoner/%1$s", summonerId);
    Type type = CurrentGameInfo.class;
    return riotApi.getBasic(url, region, type);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getFeaturedGames">Link to Portal</a><br>
   * @param region Region to execute against. */
  public FeaturedGames getFeaturedGames(final Region region) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v3/featured-games");
    Type type = FeaturedGames.class;
    return riotApi.getBasic(url, region, type);}
}