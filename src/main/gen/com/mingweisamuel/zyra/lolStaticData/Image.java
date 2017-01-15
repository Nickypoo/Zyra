package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Image - This object contains image data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Image {
  public final String full;

  public final String group;

  public final int h;

  public final String sprite;

  public final int w;

  public final int x;

  public final int y;

  public Image(final String full, final String group, final int h, final String sprite, final int w,
      final int x, final int y) {
    this.full = full;
    this.group = group;
    this.h = h;
    this.sprite = sprite;
    this.w = w;
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Image)) return false;
    final Image other = (Image) obj;
    return true
        && Objects.equal(full, other.full)
        && Objects.equal(group, other.group)
        && Objects.equal(h, other.h)
        && Objects.equal(sprite, other.sprite)
        && Objects.equal(w, other.w)
        && Objects.equal(x, other.x)
        && Objects.equal(y, other.y);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        full,
        group,
        h,
        sprite,
        w,
        x,
        y);}
}
