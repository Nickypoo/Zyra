package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * LevelTip - This object contains champion level tip data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class LevelTip {
  public final List<String> effect;

  public final List<String> label;

  public LevelTip(final List<String> effect, final List<String> label) {
    this.effect = effect;
    this.label = label;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
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
