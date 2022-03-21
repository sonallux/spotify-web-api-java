package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * AudioAnalysisObject
 */
@Getter
@Setter
@NoArgsConstructor
public class AudioAnalysis {
    /**
     * <p>The time intervals of the bars throughout the track. A bar (or measure) is a segment of time defined as a given number of beats.</p>
     */
    public java.util.List<TimeInterval> bars;
    /**
     * <p>The time intervals of beats throughout the track. A beat is the basic time unit of a piece of music; for example, each tick of a metronome. Beats are typically multiples of tatums.</p>
     */
    public java.util.List<TimeInterval> beats;
    public AudioAnalysisMeta meta;
    /**
     * <p>Sections are defined by large variations in rhythm or timbre, e.g. chorus, verse, bridge, guitar solo, etc. Each section contains its own descriptions of tempo, key, mode, time_signature, and loudness.</p>
     */
    public java.util.List<Section> sections;
    /**
     * <p>Each segment contains a roughly conisistent sound throughout its duration.</p>
     */
    public java.util.List<Segment> segments;
    /**
     * <p>A tatum represents the lowest regular pulse train that a listener intuitively infers from the timing of perceived musical events (segments).</p>
     */
    public java.util.List<TimeInterval> tatums;
    public AudioAnalysisTrack track;
}
