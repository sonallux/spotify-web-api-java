package jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * Request body for <a href="https://developer.spotify.com/web-api/replace-playlists-tracks">this request</a>
 */
public class PlaylistTracksToReplace
{
    public List<String> uris;

    public PlaylistTracksToReplace()
    {
    }

    public PlaylistTracksToReplace(List<String> uris)
    {
        this.uris = uris;
    }
}
