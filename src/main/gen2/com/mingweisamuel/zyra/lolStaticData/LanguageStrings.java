package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * This object contains language strings data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getLanguageStrings">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class LanguageStrings {
  public final Map<String, String> data;

  public final String version;

  public final String type;

  public LanguageStrings(final Map<String, String> data, final String version, final String type) {
    this.data = data;
    this.version = version;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        type);}
}