package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * LevelTip.<br><br>
 *
 * This object contains champion level tip data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class LevelTip implements Serializable {
  public final List<String> effect;

  public final List<String> label;

  public LevelTip(final List<String> effect, final List<String> label) {
    this.effect = effect;
    this.label = label;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LevelTip)) return false;
    final LevelTip other = (LevelTip) obj;
    return true
        && Objects.equal(effect, other.effect)
        && Objects.equal(label, other.label);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        effect,
        label);}
}
