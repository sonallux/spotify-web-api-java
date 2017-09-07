package jsone_studios.wrapper.spotify.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The optional request body of <a href="https://developer.spotify.com/web-api/follow-playlist/">this request</a>
 */
public class PlaylistFollowPrivacy
{
    @JsonProperty("public")
    public boolean is_public;

    public PlaylistFollowPrivacy()
    {
    }
}
