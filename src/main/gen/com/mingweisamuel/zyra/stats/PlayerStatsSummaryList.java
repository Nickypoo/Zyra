package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * PlayerStatsSummaryList - This object contains a collection of player stats summary information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class PlayerStatsSummaryList {
  /**
   * Collection of player stats summaries associated with the summoner. */
  public final List<PlayerStatsSummary> playerStatSummaries;

  /**
   * Summoner ID. */
  public final long summonerId;

  public PlayerStatsSummaryList(final List<PlayerStatsSummary> playerStatSummaries,
      final long summonerId) {
    this.playerStatSummaries = playerStatSummaries;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof PlayerStatsSummaryList)) return false;
    final PlayerStatsSummaryList other = (PlayerStatsSummaryList) obj;
    return true
        && Objects.equal(playerStatSummaries, other.playerStatSummaries)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        playerStatSummaries,
        summonerId);}
}
