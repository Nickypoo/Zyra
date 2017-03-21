package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v1.0/GET_getShardStatus">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Message {
  public final String severity;

  public final String author;

  public final String created_at;

  public final List<Translation> translations;

  public final String updated_at;

  public final String content;

  public final String id;

  public Message(final String severity, final String author, final String created_at,
      final List<Translation> translations, final String updated_at, final String content,
      final String id) {
    this.severity = severity;
    this.author = author;
    this.created_at = created_at;
    this.translations = translations;
    this.updated_at = updated_at;
    this.content = content;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStatus)) return false;
    final LolStatus other = (LolStatus) obj;
    return true
        && Objects.equal(severity, other.severity)
        && Objects.equal(author, other.author)
        && Objects.equal(created_at, other.created_at)
        && Objects.equal(translations, other.translations)
        && Objects.equal(updated_at, other.updated_at)
        && Objects.equal(content, other.content)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        severity,
        author,
        created_at,
        translations,
        updated_at,
        content,
        id);}
}