package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * This object contains champion list data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ChampionList {
  public final Map<String, String> keys;

  public final Map<String, Champion> data;

  public final String version;

  public final String type;

  public final String format;

  public ChampionList(final Map<String, String> keys, final Map<String, Champion> data,
      final String version, final String type, final String format) {
    this.keys = keys;
    this.data = data;
    this.version = version;
    this.type = type;
    this.format = format;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(keys, other.keys)
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type)
        && Objects.equal(format, other.format);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        keys,
        data,
        version,
        type,
        format);}
}