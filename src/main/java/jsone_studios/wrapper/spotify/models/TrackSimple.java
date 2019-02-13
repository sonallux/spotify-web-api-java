package jsone_studios.wrapper.spotify.models;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#track-object-simplified">Track object model (simplified)</a>
 */
public class TrackSimple
{
    public List<ArtistSimple> artists;
    public List<String> available_markets;
    public boolean is_playable;
    public LinkedTrack linked_from;
    public int disc_number;
    public int duration_ms;
    public boolean explicit;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public String name;
    public String preview_url;
    public int track_number;
    public String type;
    public String uri;

    public TrackSimple()
    {
    }
}
