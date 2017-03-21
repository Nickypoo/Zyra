package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains information about banned champions.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class BannedChampion {
  /**
   * Turn during which the champion was banned */
  public final int pickTurn;

  /**
   * Banned champion ID */
  public final int championId;

  public BannedChampion(final int pickTurn, final int championId) {
    this.pickTurn = pickTurn;
    this.championId = championId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(pickTurn, other.pickTurn)
        && Objects.equal(championId, other.championId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pickTurn,
        championId);}
}