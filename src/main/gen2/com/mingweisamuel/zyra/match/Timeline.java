package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains game timeline information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Timeline {
  /**
   * List of timeline frames for the game. */
  public final List<Frame> frames;

  /**
   * Time between each returned frame in milliseconds. */
  public final long frameInterval;

  public Timeline(final List<Frame> frames, final long frameInterval) {
    this.frames = frames;
    this.frameInterval = frameInterval;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(frames, other.frames)
        && Objects.equal(frameInterval, other.frameInterval);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        frames,
        frameInterval);}
}