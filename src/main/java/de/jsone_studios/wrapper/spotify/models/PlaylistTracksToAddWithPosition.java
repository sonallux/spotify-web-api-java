package de.jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * Request body for <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist">this request</a>
 */
public class PlaylistTracksToAddWithPosition
{
    public List<String> uris;
    public int position;

    public PlaylistTracksToAddWithPosition()
    {
    }

    public PlaylistTracksToAddWithPosition(List<String> uris, int position)
    {
        this.uris = uris;
        this.position = position;
    }
}