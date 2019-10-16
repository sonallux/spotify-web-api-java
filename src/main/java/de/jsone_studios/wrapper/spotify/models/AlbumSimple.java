package de.jsone_studios.wrapper.spotify.models;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#album-object-simplified">Album object model (simplified)</a>
 */
public class AlbumSimple
{
    public String album_type;
    public List<ArtistSimple> artists;
    public List<String> available_markets;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public String release_date;
    public String release_date_precision;
    public int total_tracks;
    public String type;
    public String uri;

    public AlbumSimple()
    {
    }
}
