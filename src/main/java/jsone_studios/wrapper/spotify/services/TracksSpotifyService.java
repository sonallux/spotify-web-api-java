package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.AudioFeaturesTrack;
import jsone_studios.wrapper.spotify.models.AudioFeaturesTracks;
import jsone_studios.wrapper.spotify.models.Track;
import jsone_studios.wrapper.spotify.models.Tracks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface TracksSpotifyService
{
    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId The Spotify ID for the track.
     * @return Requested track information
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    Call<Track> getTrack(@Path("id") String trackId);

    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId The Spotify ID for the track.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-track/">endpoint documentation</a>
     * @return Requested track information
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    Call<Track> getTrack(@Path("id") String trackId, @QueryMap Map<String, Object> options);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    Call<Tracks> getTracks(@Query("ids") String trackIds);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-several-tracks/">endpoint documentation</a>
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    Call<Tracks> getTracks(@Query("ids") String trackIds, @QueryMap Map<String, Object> options);

    /**
     * Get audio features for multiple tracks based on their Spotify IDs.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks. Maximum: 100 IDs
     * @return An object whose key is "audio_features" and whose value is an array of audio features objects.
     */
    @GET("/audio-features")
    Call<AudioFeaturesTracks> getTracksAudioFeatures(@Query("ids") String ids);

    /**
     * Get audio feature information for a single track identified by its unique Spotify ID.
     *
     * @param id The Spotify ID for the track.
     * @return Audio features object
     */
    @GET("/audio-features/{id}")
    Call<AudioFeaturesTrack> getTrackAudioFeatures(@Path("id") String id);
}
