package de.jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * Request body for <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist">this request</a>
 */
public class PlaylistTracksToAdd
{
    public List<String> uris;

    public PlaylistTracksToAdd()
    {
    }

    public PlaylistTracksToAdd(List<String> uris)
    {
        this.uris = uris;
    }
}
