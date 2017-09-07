package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface LibrarySpotifyService
{
    /**
     * Get a list of the songs saved in the current Spotify user’s “Your Music” library.
     *
     * @return A paginated list of saved tracks
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">Get a User’s Saved Tracks</a>
     */
    @GET("/me/tracks")
    Call<Pager<SavedTrack>> getMySavedTracks();

    /**
     * Get a list of the songs saved in the current Spotify user’s “Your Music” library.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">endpoint documentation</a>
     * @return A paginated list of saved tracks
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">Get a User’s Saved Tracks</a>
     */
    @GET("/me/tracks")
    Call<Pager<SavedTrack>> getMySavedTracks(@QueryMap Map<String, Object> options);

    /**
     * Check if one or more tracks is already saved in the current Spotify user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks
     * @return An array with boolean values that indicate whether the tracks are in the current Spotify user’s “Your Music” library.
     * @see <a href="https://developer.spotify.com/web-api/check-users-saved-tracks/">Check User’s Saved Tracks</a>
     */
    @GET("/me/tracks/contains")
    Call<Boolean[]> containsMySavedTracks(@Query("ids") String ids);

    /**
     * Save one or more tracks to the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-tracks-user/">Save Tracks for User</a>
     */
    @PUT("/me/tracks")
    Call<Result> addToMySavedTracks(@Query("ids") String ids);

    /**
     * Remove one or more tracks from the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-user/">Remove User’s Saved Tracks</a>
     */
    @DELETE("/me/tracks")
    Call<Result> removeFromMySavedTracks(@Query("ids") String ids);

    /**
     * Get a list of the albums saved in the current Spotify user’s “Your Music” library.
     *
     * @return A paginated list of saved albums
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">Get a User’s Saved Albums</a>
     */
    @GET("/me/albums")
    Call<Pager<SavedAlbum>> getMySavedAlbums();

    /**
     * Get a list of the albums saved in the current Spotify user’s “Your Music” library.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">endpoint documentation</a>
     * @return A paginated list of saved albums
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">Get a User’s Saved Albums</a>
     */
    @GET("/me/albums")
    Call<Pager<SavedAlbum>> getMySavedAlbums(@QueryMap Map<String, Object> options);

    /**
     * Check if one or more albums is already saved in the current Spotify user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums
     * @return An array with boolean values that indicate whether the albums are in the current Spotify user’s “Your Music” library.
     * @see <a href="https://developer.spotify.com/web-api/check-users-saved-albums/">Check User’s Saved Albums</a>
     */
    @GET("/me/albums/contains")
    Call<Boolean[]> containsMySavedAlbums(@Query("ids") String ids);

    /**
     * Save one or more albums to the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-albums-user/">Save Albums for User</a>
     */
    @PUT("/me/albums")
    Call<Result> addToMySavedAlbums(@Query("ids") String ids);

    /**
     * Remove one or more albums from the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-albums-user/">Remove User’s Saved Albums</a>
     */
    @DELETE("/me/albums")
    Call<Result> removeFromMySavedAlbums(@Query("ids") String ids);

    /**
     * Get the current user’s top artists based on calculated affinity.
     *
     * @return The objects whose response body contains an artists or tracks object.
     * The object in turn contains a paging object of Artists or Tracks
     */
    @GET("/me/top/artists")
    Call<Pager<Artist>> getTopArtists();

    /**
     * Get the current user’s top artists based on calculated affinity.
     *
     * @param options Optional parameters. For list of available parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-top-artists-and-tracks/">endpoint documentation</a>
     * @return The objects whose response body contains an artists or tracks object.
     * The object in turn contains a paging object of Artists or Tracks
     */
    @GET("/me/top/artists")
    Call<Pager<Artist>> getTopArtists(@QueryMap Map<String, Object> options);

    /**
     * Get the current user’s top tracks based on calculated affinity.
     *
     * @return The objects whose response body contains an artists or tracks object.
     * The object in turn contains a paging object of Artists or Tracks
     */
    @GET("/me/top/tracks")
    Call<Pager<Track>> getTopTracks();

    /**
     * Get the current user’s top tracks based on calculated affinity.
     *
     * @param options Optional parameters. For list of available parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-top-artists-and-tracks/">endpoint documentation</a>
     * @return The objects whose response body contains an artists or tracks object.
     * The object in turn contains a paging object of Artists or Tracks
     */
    @GET("/me/top/tracks")
    Call<Pager<Track>> getTopTracks(@QueryMap Map<String, Object> options);

    //TODO: add new recently played
}
