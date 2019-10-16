package de.jsone_studios.wrapper.spotify.services;

import de.jsone_studios.wrapper.spotify.models.SavedAlbum;
import de.jsone_studios.wrapper.spotify.models.Pager;
import de.jsone_studios.wrapper.spotify.models.Result;
import de.jsone_studios.wrapper.spotify.models.SavedTrack;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface LibrarySpotifyService
{
    /**
     * Check if one or more albums is already saved in the current Spotify user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums. Maximum: 50 IDs.
     * @return An array with boolean values that indicate whether the albums are in the current Spotify user’s “Your Music” library.
     * @see <a href="https://developer.spotify.com/web-api/check-users-saved-albums/">Check User’s Saved Albums</a>
     */
    @GET("me/albums/contains")
    Call<Boolean[]> containsMySavedAlbums(@Query("ids") String ids);

    /**
     * Check if one or more tracks is already saved in the current Spotify user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks. Maximum: 50 IDs.
     * @return An array with boolean values that indicate whether the tracks are in the current Spotify user’s “Your Music” library.
     * @see <a href="https://developer.spotify.com/web-api/check-users-saved-tracks/">Check User’s Saved Tracks</a>
     */
    @GET("me/tracks/contains")
    Call<Boolean[]> containsMySavedTracks(@Query("ids") String ids);

    /**
     * Get a list of the albums saved in the current Spotify user’s “Your Music” library.
     *
     * @return A paginated list of saved albums
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">Get a User’s Saved Albums</a>
     */
    @GET("me/albums")
    Call<Pager<SavedAlbum>> getMySavedAlbums();

    /**
     * Get a list of the albums saved in the current Spotify user’s “Your Music” library.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">endpoint documentation</a>
     * @return A paginated list of saved albums
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-albums/">Get a User’s Saved Albums</a>
     */
    @GET("me/albums")
    Call<Pager<SavedAlbum>> getMySavedAlbums(@QueryMap Map<String, Object> options);

    /**
     * Get a list of the songs saved in the current Spotify user’s “Your Music” library.
     *
     * @return A paginated list of saved tracks
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">Get a User’s Saved Tracks</a>
     */
    @GET("me/tracks")
    Call<Pager<SavedTrack>> getMySavedTracks();

    /**
     * Get a list of the songs saved in the current Spotify user’s “Your Music” library.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">endpoint documentation</a>
     * @return A paginated list of saved tracks
     * @see <a href="https://developer.spotify.com/web-api/get-users-saved-tracks/">Get a User’s Saved Tracks</a>
     */
    @GET("me/tracks")
    Call<Pager<SavedTrack>> getMySavedTracks(@QueryMap Map<String, Object> options);

    /**
     * Remove one or more albums from the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-albums-user/">Remove User’s Saved Albums</a>
     */
    @DELETE("me/albums")
    Call<Result> removeFromMySavedAlbums(@Query("ids") String ids);

    /**
     * Remove one or more albums from the current user’s “Your Music” library.
     *
     * @param ids A list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-albums-user/">Remove User’s Saved Albums</a>
     */
    @DELETE("me/albums")
    Call<Result> removeFromMySavedAlbums(@Body String[] ids);

    /**
     * Remove one or more tracks from the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-user/">Remove User’s Saved Tracks</a>
     */
    @DELETE("me/tracks")
    Call<Result> removeFromMySavedTracks(@Query("ids") String ids);

    /**
     * Remove one or more tracks from the current user’s “Your Music” library.
     *
     * @param ids A list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-user/">Remove User’s Saved Tracks</a>
     */
    @DELETE("me/tracks")
    Call<Result> removeFromMySavedTracks(@Body String[] ids);

    /**
     * Save one or more albums to the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-albums-user/">Save Albums for User</a>
     */
    @PUT("me/albums")
    Call<Result> addToMySavedAlbums(@Query("ids") String ids);

    /**
     * Save one or more albums to the current user’s “Your Music” library.
     *
     * @param ids A list of the Spotify IDs for the albums
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-albums-user/">Save Albums for User</a>
     */
    @PUT("me/albums")
    Call<Result> addToMySavedAlbums(@Body String[] ids);

    /**
     * Save one or more tracks to the current user’s “Your Music” library.
     *
     * @param ids A comma-separated list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-tracks-user/">Save Tracks for User</a>
     */
    @PUT("me/tracks")
    Call<Result> addToMySavedTracks(@Query("ids") String ids);

    /**
     * Save one or more tracks to the current user’s “Your Music” library.
     *
     * @param ids A list of the Spotify IDs for the tracks
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/save-tracks-user/">Save Tracks for User</a>
     */
    @PUT("me/tracks")
    Call<Result> addToMySavedTracks(@Body String[] ids);
}
