package jsone_studios.wrapper.spotify.models;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#album-object-simplified">Album object model (simplified)</a>
 */
public class AlbumSimple
{
    public List<ArtistSimple> artists;
    public String album_type;
    public List<String> available_markets;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public String type;
    public String uri;

    public AlbumSimple()
    {
    }
}
