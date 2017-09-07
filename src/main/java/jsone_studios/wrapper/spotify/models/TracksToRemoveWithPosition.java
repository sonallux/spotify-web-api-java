package jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * Request body for <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">this request</a>
 */
public class TracksToRemoveWithPosition
{
    public List<TrackToRemoveWithPosition> tracks;

    public TracksToRemoveWithPosition()
    {
    }
}
