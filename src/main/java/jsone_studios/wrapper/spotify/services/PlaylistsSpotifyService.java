package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
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

    /**
     * Get the current image associated with a specific playlist.
     *
     * @param playlistId The Spotify ID for the playlist
     * @return A list of image objects
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/playlists/get-playlist-cover">Get a Playlist Cover Image</a>
     */
    @GET("playlists/{playlist_id}/images")
    Call<List<Image>> getPlaylistCoverImages(@Path("playlist_id") String playlistId);

    /**
     * Replace the image used to represent a specific playlist.
     *
     * @param playlistId The Spotify ID for the playlist
     * @param base64Image Base64 encoded JPEG image data, maximum payload size is 256 KB
     * @return A successful request will return a 202 ACCEPTED response code
     */
    @PUT("playlists/{playlist_id}/images")
    @Headers({"Content-Type: image/jpeg"})
    Call<Result> uploadPlaylistCoverImage(@Path("playlist_id") String playlistId, @Body String base64Image);
}
