package de.jsone_studios.wrapper.spotify.models;

import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#track-object-full">Track object model</a>
 */
public class Track extends TrackSimple
{
    public AlbumSimple album;
    public Map<String, String> external_ids;
    public int popularity;

    public Track()
    {
    }
}