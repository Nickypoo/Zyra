package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * ItemTree - This object contains item tree data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class ItemTree {
  public final String header;

  public final List<String> tags;

  public ItemTree(final String header, final List<String> tags) {
    this.header = header;
    this.tags = tags;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof ItemTree)) return false;
    final ItemTree other = (ItemTree) obj;
    return true
        && Objects.equal(header, other.header)
        && Objects.equal(tags, other.tags);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        header,
        tags);}
}
