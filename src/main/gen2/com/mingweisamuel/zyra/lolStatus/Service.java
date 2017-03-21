package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v1.0/GET_getShardStatus">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Service {
  public final String status;

  public final List<Incident> incidents;

  public final String name;

  public final String slug;

  public Service(final String status, final List<Incident> incidents, final String name,
      final String slug) {
    this.status = status;
    this.incidents = incidents;
    this.name = name;
    this.slug = slug;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStatus)) return false;
    final LolStatus other = (LolStatus) obj;
    return true
        && Objects.equal(status, other.status)
        && Objects.equal(incidents, other.incidents)
        && Objects.equal(name, other.name)
        && Objects.equal(slug, other.slug);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        status,
        incidents,
        name,
        slug);}
}