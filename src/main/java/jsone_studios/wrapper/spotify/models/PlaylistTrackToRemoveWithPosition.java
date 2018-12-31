package jsone_studios.wrapper.spotify.models;

import java.util.List;

public class PlaylistTrackToRemoveWithPosition
{
    public String uri;
    public List<Integer> positions;

    public PlaylistTrackToRemoveWithPosition()
    {
    }

    public PlaylistTrackToRemoveWithPosition(String uri, List<Integer> positions)
    {
        this.uri = uri;
        this.positions = positions;
    }
}
