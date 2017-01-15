package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RunePages - This object contains rune pages information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version summoner-v1.4 */
public class RunePages {
  /**
   * Collection of rune pages associated with the summoner. */
  public final List<RunePage> pages;

  /**
   * Summoner ID. */
  public final long summonerId;

  public RunePages(final List<RunePage> pages, final long summonerId) {
    this.pages = pages;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof RunePages)) return false;
    final RunePages other = (RunePages) obj;
    return true
        && Objects.equal(pages, other.pages)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pages,
        summonerId);}
}
