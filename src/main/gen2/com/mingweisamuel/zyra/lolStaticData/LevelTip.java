package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains champion level tip data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class LevelTip {
  public final List<String> effect;

  public final List<String> label;

  public LevelTip(final List<String> effect, final List<String> label) {
    this.effect = effect;
    this.label = label;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(effect, other.effect)
        && Objects.equal(label, other.label);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        effect,
        label);}
}