package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains champion spell data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ChampionSpell {
  public final String cooldownBurn;

  public final String resource;

  public final LevelTip leveltip;

  public final List<SpellVars> vars;

  public final String costType;

  public final List<Image> altimages;

  public final String sanitizedDescription;

  public final String sanitizedTooltip;

  /**
   * This field is a List of List of Double. */
  public final List<List<Double>> effect;

  public final String tooltip;

  public final int maxrank;

  public final String costBurn;

  public final String rangeBurn;

  /**
   * This field is either a List of Integer or the String 'self' for spells that target one's own champion. */
  public final List<Integer> range;

  public final List<Double> cooldown;

  public final List<Integer> cost;

  public final String key;

  public final String description;

  public final List<String> effectBurn;

  public final Image image;

  public final String name;

  public ChampionSpell(final String cooldownBurn, final String resource, final LevelTip leveltip,
      final List<SpellVars> vars, final String costType, final List<Image> altimages,
      final String sanitizedDescription, final String sanitizedTooltip,
      final List<List<Double>> effect, final String tooltip, final int maxrank,
      final String costBurn, final String rangeBurn, final List<Integer> range,
      final List<Double> cooldown, final List<Integer> cost, final String key,
      final String description, final List<String> effectBurn, final Image image,
      final String name) {
    this.cooldownBurn = cooldownBurn;
    this.resource = resource;
    this.leveltip = leveltip;
    this.vars = vars;
    this.costType = costType;
    this.altimages = altimages;
    this.sanitizedDescription = sanitizedDescription;
    this.sanitizedTooltip = sanitizedTooltip;
    this.effect = effect;
    this.tooltip = tooltip;
    this.maxrank = maxrank;
    this.costBurn = costBurn;
    this.rangeBurn = rangeBurn;
    this.range = range;
    this.cooldown = cooldown;
    this.cost = cost;
    this.key = key;
    this.description = description;
    this.effectBurn = effectBurn;
    this.image = image;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(cooldownBurn, other.cooldownBurn)
        && Objects.equal(resource, other.resource)
        && Objects.equal(leveltip, other.leveltip)
        && Objects.equal(vars, other.vars)
        && Objects.equal(costType, other.costType)
        && Objects.equal(altimages, other.altimages)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(sanitizedTooltip, other.sanitizedTooltip)
        && Objects.equal(effect, other.effect)
        && Objects.equal(tooltip, other.tooltip)
        && Objects.equal(maxrank, other.maxrank)
        && Objects.equal(costBurn, other.costBurn)
        && Objects.equal(rangeBurn, other.rangeBurn)
        && Objects.equal(range, other.range)
        && Objects.equal(cooldown, other.cooldown)
        && Objects.equal(cost, other.cost)
        && Objects.equal(key, other.key)
        && Objects.equal(description, other.description)
        && Objects.equal(effectBurn, other.effectBurn)
        && Objects.equal(image, other.image)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        cooldownBurn,
        resource,
        leveltip,
        vars,
        costType,
        altimages,
        sanitizedDescription,
        sanitizedTooltip,
        effect,
        tooltip,
        maxrank,
        costBurn,
        rangeBurn,
        range,
        cooldown,
        cost,
        key,
        description,
        effectBurn,
        image,
        name);}
}