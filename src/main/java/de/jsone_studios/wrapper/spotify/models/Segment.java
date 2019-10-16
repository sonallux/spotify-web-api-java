package de.jsone_studios.wrapper.spotify.models;

public class Segment
{
    public float start;
    public float duration;
    public float confidence;
    public float loudness_start;
    public float loudness_max;
    public float loudness_max_time;
    public float loudness_end;
    public float[] pitches;
    public float[] timbre;

    public Segment()
    {
    }
}
