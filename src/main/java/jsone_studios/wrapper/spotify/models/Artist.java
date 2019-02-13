package jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#artist-object-full">Artist object model</a>
 */
public class Artist extends ArtistSimple
{
    public Followers followers;
    public List<String> genres;
    public List<Image> images;
    public int popularity;

    public Artist()
    {
    }
}