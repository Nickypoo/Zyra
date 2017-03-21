package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains champion data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Champion {
  public final Info info;

  public final List<String> enemytips;

  public final Stats stats;

  public final String name;

  public final List<String> tags;

  public final Image image;

  public final String title;

  public final String partype;

  public final List<Skin> skins;

  public final Passive passive;

  public final List<Recommended> recommended;

  public final List<String> allytips;

  public final String key;

  public final String lore;

  public final int id;

  public final String blurb;

  public final List<ChampionSpell> spells;

  public Champion(final Info info, final List<String> enemytips, final Stats stats,
      final String name, final List<String> tags, final Image image, final String title,
      final String partype, final List<Skin> skins, final Passive passive,
      final List<Recommended> recommended, final List<String> allytips, final String key,
      final String lore, final int id, final String blurb, final List<ChampionSpell> spells) {
    this.info = info;
    this.enemytips = enemytips;
    this.stats = stats;
    this.name = name;
    this.tags = tags;
    this.image = image;
    this.title = title;
    this.partype = partype;
    this.skins = skins;
    this.passive = passive;
    this.recommended = recommended;
    this.allytips = allytips;
    this.key = key;
    this.lore = lore;
    this.id = id;
    this.blurb = blurb;
    this.spells = spells;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(info, other.info)
        && Objects.equal(enemytips, other.enemytips)
        && Objects.equal(stats, other.stats)
        && Objects.equal(name, other.name)
        && Objects.equal(tags, other.tags)
        && Objects.equal(image, other.image)
        && Objects.equal(title, other.title)
        && Objects.equal(partype, other.partype)
        && Objects.equal(skins, other.skins)
        && Objects.equal(passive, other.passive)
        && Objects.equal(recommended, other.recommended)
        && Objects.equal(allytips, other.allytips)
        && Objects.equal(key, other.key)
        && Objects.equal(lore, other.lore)
        && Objects.equal(id, other.id)
        && Objects.equal(blurb, other.blurb)
        && Objects.equal(spells, other.spells);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        info,
        enemytips,
        stats,
        name,
        tags,
        image,
        title,
        partype,
        skins,
        passive,
        recommended,
        allytips,
        key,
        lore,
        id,
        blurb,
        spells);}
}