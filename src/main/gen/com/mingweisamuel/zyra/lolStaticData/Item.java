package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Item.<br><br>
 *
 * This object contains item data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class Item implements Serializable {
  public final Gold gold;

  public final String plaintext;

  public final boolean hideFromAll;

  public final boolean inStore;

  public final List<String> into;

  public final int id;

  public final InventoryDataStats stats;

  public final String colloq;

  public final Map<Integer, Boolean> maps;

  public final int specialRecipe;

  public final Image image;

  public final String description;

  public final List<String> tags;

  public final Map<String, String> effect;

  public final String requiredChampion;

  public final List<String> from;

  public final String group;

  public final boolean consumeOnFull;

  public final String name;

  public final boolean consumed;

  public final String sanitizedDescription;

  public final int depth;

  public final int stacks;

  public Item(final Gold gold, final String plaintext, final boolean hideFromAll,
      final boolean inStore, final List<String> into, final int id, final InventoryDataStats stats,
      final String colloq, final Map<Integer, Boolean> maps, final int specialRecipe,
      final Image image, final String description, final List<String> tags,
      final Map<String, String> effect, final String requiredChampion, final List<String> from,
      final String group, final boolean consumeOnFull, final String name, final boolean consumed,
      final String sanitizedDescription, final int depth, final int stacks) {
    this.gold = gold;
    this.plaintext = plaintext;
    this.hideFromAll = hideFromAll;
    this.inStore = inStore;
    this.into = into;
    this.id = id;
    this.stats = stats;
    this.colloq = colloq;
    this.maps = maps;
    this.specialRecipe = specialRecipe;
    this.image = image;
    this.description = description;
    this.tags = tags;
    this.effect = effect;
    this.requiredChampion = requiredChampion;
    this.from = from;
    this.group = group;
    this.consumeOnFull = consumeOnFull;
    this.name = name;
    this.consumed = consumed;
    this.sanitizedDescription = sanitizedDescription;
    this.depth = depth;
    this.stacks = stacks;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Item)) return false;
    final Item other = (Item) obj;
    return true
        && Objects.equal(gold, other.gold)
        && Objects.equal(plaintext, other.plaintext)
        && Objects.equal(hideFromAll, other.hideFromAll)
        && Objects.equal(inStore, other.inStore)
        && Objects.equal(into, other.into)
        && Objects.equal(id, other.id)
        && Objects.equal(stats, other.stats)
        && Objects.equal(colloq, other.colloq)
        && Objects.equal(maps, other.maps)
        && Objects.equal(specialRecipe, other.specialRecipe)
        && Objects.equal(image, other.image)
        && Objects.equal(description, other.description)
        && Objects.equal(tags, other.tags)
        && Objects.equal(effect, other.effect)
        && Objects.equal(requiredChampion, other.requiredChampion)
        && Objects.equal(from, other.from)
        && Objects.equal(group, other.group)
        && Objects.equal(consumeOnFull, other.consumeOnFull)
        && Objects.equal(name, other.name)
        && Objects.equal(consumed, other.consumed)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(depth, other.depth)
        && Objects.equal(stacks, other.stacks);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        gold,
        plaintext,
        hideFromAll,
        inStore,
        into,
        id,
        stats,
        colloq,
        maps,
        specialRecipe,
        image,
        description,
        tags,
        effect,
        requiredChampion,
        from,
        group,
        consumeOnFull,
        name,
        consumed,
        sanitizedDescription,
        depth,
        stacks);}
}
