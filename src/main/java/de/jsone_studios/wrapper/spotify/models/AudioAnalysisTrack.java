package de.jsone_studios.wrapper.spotify.models;

import java.util.List;

public class AudioAnalysisTrack
{
    public List<TimeInterval> bars;
    public List<TimeInterval> beats;
    public List<Section> sections;
    public List<Segment> segments;
    public List<TimeInterval> tatums;

    public AudioAnalysisTrack()
    {
    }
}
