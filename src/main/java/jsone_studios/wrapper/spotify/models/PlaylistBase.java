package jsone_studios.wrapper.spotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Base class for {@link Playlist} and
 * {@link jsone_studios.wrapper.spotify.models.PlaylistSimple}
 */
public abstract class PlaylistBase
{
    public boolean collaborative;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public UserPublic owner;
    @JsonProperty("public")
    public boolean is_public;
    public String snapshot_id;
    public String type;
    public String uri;

    protected PlaylistBase()
    {
    }
}
