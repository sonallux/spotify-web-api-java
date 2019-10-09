package jsone_studios.wrapper.spotify.models;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#album-object-full">Album object model</a>
 */
public class Album extends AlbumSimple
{
    public List<Copyright> copyrights;
    public Map<String, String> external_ids;
    public List<String> genres;
    public String label;
    public int popularity;
    public Pager<TrackSimple> tracks;

    public Album()
    {
    }
}