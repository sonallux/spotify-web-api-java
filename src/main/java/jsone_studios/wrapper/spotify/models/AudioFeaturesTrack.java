package jsone_studios.wrapper.spotify.models;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#audio-features-object">Audio Features Object</a>
 */
public class AudioFeaturesTrack
{

    public float acousticness;
    public String analysis_url;
    public float danceability;
    public int duration_ms;
    public float energy;
    public String id;
    public float instrumentalness;
    public int key;
    public float liveness;
    public float loudness;
    public int mode;
    public float speechiness;
    public float tempo;
    public int time_signature;
    public String track_href;
    public String type;
    public String uri;
    public float valence;

    public AudioFeaturesTrack()
    {
    }
}
