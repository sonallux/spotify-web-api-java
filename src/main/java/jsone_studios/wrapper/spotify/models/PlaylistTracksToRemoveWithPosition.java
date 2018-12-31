package jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * Request body for <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">this request</a>
 */
public class PlaylistTracksToRemoveWithPosition
{
    public List<PlaylistTrackToRemoveWithPosition> tracks;

    public PlaylistTracksToRemoveWithPosition()
    {
    }

    public PlaylistTracksToRemoveWithPosition(List<PlaylistTrackToRemoveWithPosition> tracks)
    {
        this.tracks = tracks;
    }
}
