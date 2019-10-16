package de.jsone_studios.wrapper.spotify.models;

import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#track-link">track link object model</a>
 */
public class LinkedTrack
{
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public String type;
    public String uri;

    public LinkedTrack()
    {
    }
}