package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.Pager;
import jsone_studios.wrapper.spotify.models.Playlist;
import jsone_studios.wrapper.spotify.models.PlaylistSimple;
import jsone_studios.wrapper.spotify.models.Result;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface PlaylistsSpotifyService
{
    /**
     * Get a list of the playlists owned or followed by the current Spotify user.
     *
     * @return List of user's playlists wrapped in a {@code Pager} object
     */
    @GET("me/playlists")
    Call<Pager<PlaylistSimple>> getMyPlaylists();

    /**
     * Get a list of the playlists owned or followed by the current Spotify user.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-a-list-of-current-users-playlists/">endpoint documentation</a>
     * @return List of user's playlists wrapped in a {@code Pager} object
     */
    @GET("me/playlists")
    Call<Pager<PlaylistSimple>> getMyPlaylists(@QueryMap Map<String, Object> options);

    /**
     * Get a list of the playlists owned or followed by a Spotify user.
     *
     * @param userId The user's Spotify user ID.
     * @return List of user's playlists wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-list-users-playlists/">Get a List of a User’s Playlists</a>
     */
    @GET("users/{id}/playlists")
    Call<Pager<PlaylistSimple>> getPlaylists(@Path("id") String userId);

    /**
     * Get a list of the playlists owned or followed by a Spotify user.
     *
     * @param userId  The user's Spotify user ID.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-list-users-playlists/">endpoint documentation</a>
     * @return List of user's playlists wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-list-users-playlists/">Get a List of a User’s Playlists</a>
     */
    @GET("users/{id}/playlists")
    Call<Pager<PlaylistSimple>> getPlaylists(@Path("id") String userId, @QueryMap Map<String, Object> options);

    /**
     * Get a playlist owned by a Spotify user.
     *
     * @param playlistId The Spotify ID for the playlist.
     * @return Requested Playlist.
     * @see <a href="https://developer.spotify.com/web-api/get-playlist/">Get a Playlist</a>
     */
    @GET("playlists/{playlist_id}")
    Call<Playlist> getPlaylist(@Path("playlist_id") String playlistId);

    /**
     * Get a playlist owned by a Spotify user.
     *
     * @param playlistId The Spotify ID for the playlist.
     * @param options    Optional parameters. For list of supported parameters see
     *                   <a href="https://developer.spotify.com/web-api/get-playlist/">endpoint documentation</a>
     * @return Requested Playlist.
     * @see <a href="https://developer.spotify.com/web-api/get-playlist/">Get a Playlist</a>
     */
    @GET("playlists/{playlist_id}")
    Call<Playlist> getPlaylist(@Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options);

    /**
     * Create a playlist
     *
     * @param userId  The playlist's owner's User ID
     * @param options The body parameters
     * @return The created playlist
     * @see <a href="https://developer.spotify.com/web-api/create-playlist/">Create a Playlist</a>
     */
    @POST("users/{user_id}/playlists")
    Call<Playlist> createPlaylist(@Path("user_id") String userId, @Body Map<String, Object> options);


    /**
     * Change a playlist’s name and public/private state. (The user must, of course, own the playlist.)
     *
     * @param playlistId The playlist's Id
     * @param body       The body parameters. For list of supported parameters see <a href="https://developer.spotify.com/web-api/change-playlist-details/">endpoint documentation</a>
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/change-playlist-details/">Change a Playlist's Details</a>
     */
    @PUT("playlists/{playlist_id}")
    Call<Result> changePlaylistDetails(@Path("playlist_id") String playlistId, @Body Map<String, Object> body);
}
