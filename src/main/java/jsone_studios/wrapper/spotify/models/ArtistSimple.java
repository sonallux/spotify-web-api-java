package jsone_studios.wrapper.spotify.models;

import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#artist-object-simplified">Artist object model (simplified)</a>
 */
public class ArtistSimple
{
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public String name;
    public String type;
    public String uri;

    public ArtistSimple()
    {
    }
}
