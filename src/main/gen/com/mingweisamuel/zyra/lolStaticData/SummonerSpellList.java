package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * SummonerSpellList - This object contains summoner spell list data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class SummonerSpellList {
  public final Map<Integer, SummonerSpell> data;

  public final String type;

  public final String version;

  public SummonerSpellList(final Map<Integer, SummonerSpell> data, final String type,
      final String version) {
    this.data = data;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof SummonerSpellList)) return false;
    final SummonerSpellList other = (SummonerSpellList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        type,
        version);}
}
