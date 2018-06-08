package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.*;
import jsone_studios.wrapper.spotify.util.SpotifyUri;
import jsone_studios.wrapper.spotify.util.SpotifyUriException;
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
     * @param userId  The user's Spotify user ID.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-list-users-playlists/">endpoint documentation</a>
     * @return List of user's playlists wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-list-users-playlists/">Get a List of a User’s Playlists</a>
     */
    @GET("users/{id}/playlists")
    Call<Pager<PlaylistSimple>> getPlaylists(@Path("id") String userId, @QueryMap Map<String, Object> options);

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
     * Get a playlist owned by a Spotify user.
     *
     * @param userId     The user's Spotify user ID.
     * @param playlistId The Spotify ID for the playlist.
     * @param options    Optional parameters. For list of supported parameters see
     *                   <a href="https://developer.spotify.com/web-api/get-playlist/">endpoint documentation</a>
     * @return Requested Playlist.
     * @see <a href="https://developer.spotify.com/web-api/get-playlist/">Get a Playlist</a>
     */
    @GET("users/{user_id}/playlists/{playlist_id}")
    Call<Playlist> getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options);

    default Call<Playlist> getPlaylist(String playlistUri, Map<String, Object> options) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return getPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), options);
    }

    /**
     * Get a playlist owned by a Spotify user.
     *
     * @param userId     The user's Spotify user ID.
     * @param playlistId The Spotify ID for the playlist.
     * @return Requested Playlist.
     * @see <a href="https://developer.spotify.com/web-api/get-playlist/">Get a Playlist</a>
     */
    @GET("users/{user_id}/playlists/{playlist_id}")
    Call<Playlist> getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);

    default Call<Playlist> getPlaylist(String playlistUri) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return getPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId());

    }
    /**
     * Get full details of the tracks of a playlist owned by a Spotify user.
     *
     * @param userId     The user's Spotify user ID.
     * @param playlistId The Spotify ID for the playlist.
     * @param options    Optional parameters. For list of supported parameters see
     *                   <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">endpoint documentation</a>
     * @return List of playlist's tracks wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">Get a Playlist’s Tracks</a>
     */
    @GET("users/{user_id}/playlists/{playlist_id}/tracks")
    Call<Pager<PlaylistTrack>> getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options);

    default Call<Pager<PlaylistTrack>> getPlaylistTracks(String playlistUri, Map<String, Object> options) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return getPlaylistTracks(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), options);
    }

    /**
     * Get full details of the tracks of a playlist owned by a Spotify user.
     *
     * @param userId     The user's Spotify user ID.
     * @param playlistId The Spotify ID for the playlist.
     * @return List of playlist's tracks wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">Get a Playlist’s Tracks</a>
     */
    @GET("users/{user_id}/playlists/{playlist_id}/tracks")
    Call<Pager<PlaylistTrack>> getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId);

    default Call<Pager<PlaylistTrack>> getPlaylistTracks(String playlistUri) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return getPlaylistTracks(spotifyUri.getUserId(), spotifyUri.getPlaylistId());
    }

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
     * Add tracks to a playlist
     *
     * @param userId          The owner of the playlist
     * @param playlistId      The playlist's ID
     * @param queryParameters Query parameters
     * @param body            The body parameters
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist/">Add Tracks to a Playlist</a>
     */
    @POST("users/{user_id}/playlists/{playlist_id}/tracks")
    Call<SnapshotId> addTracksToPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> queryParameters, @Body Map<String, Object> body);

    default Call<SnapshotId> addTracksToPlaylist(String playlistUri, Map<String, Object> queryParameters, Map<String, Object> body) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return addTracksToPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), queryParameters, body);
    }

    /**
     * Remove one or more tracks from a user’s playlist.
     *
     * @param userId         The owner of the playlist
     * @param playlistId     The playlist's Id
     * @param tracksToRemove A list of tracks to remove
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">Remove Tracks from a Playlist</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "users/{user_id}/playlists/{playlist_id}/tracks")
    Call<SnapshotId> removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemove tracksToRemove);

    default Call<SnapshotId> removeTracksFromPlaylist(String playlistUri, TracksToRemove tracksToRemove) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return removeTracksFromPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), tracksToRemove);
    }

    /**
     * Remove one or more tracks from a user’s playlist.
     *
     * @param userId                     The owner of the playlist
     * @param playlistId                 The playlist's Id
     * @param tracksToRemoveWithPosition A list of tracks to remove, together with their specific positions
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">Remove Tracks from a Playlist</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "users/{user_id}/playlists/{playlist_id}/tracks")
    Call<SnapshotId> removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemoveWithPosition tracksToRemoveWithPosition);

    default Call<SnapshotId> removeTracksFromPlaylist(String playlistUri, TracksToRemoveWithPosition tracksToRemoveWithPosition) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return removeTracksFromPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), tracksToRemoveWithPosition);
    }

    /**
     * Replace all the tracks in a playlist, overwriting its existing tracks. This powerful request can be useful for
     * replacing tracks, re-ordering existing tracks, or clearing the playlist.
     *
     * @param userId     The owner of the playlist
     * @param playlistId The playlist's Id
     * @param trackUris  A list of comma-separated track uris
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/replace-playlists-tracks/">Replace a Playlist’s Tracks</a>
     */
    @PUT("users/{user_id}/playlists/{playlist_id}/tracks")
    Call<Result> replaceTracksInPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Query("uris") String trackUris, @Body Object body);

    default Call<Result> replaceTracksInPlaylist(String playlistUri, String trackUris, Object body) throws SpotifyUriException {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return replaceTracksInPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), trackUris, body);
    }

    /**
     * Change a playlist’s name and public/private state. (The user must, of course, own the playlist.)
     *
     * @param userId     The Spotify user ID of the user who owns the playlist.
     * @param playlistId The playlist's Id
     * @param body       The body parameters. For list of supported parameters see <a href="https://developer.spotify.com/web-api/change-playlist-details/">endpoint documentation</a>
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/change-playlist-details/">Change a Playlist's Details</a>
     */
    @PUT("users/{user_id}/playlists/{playlist_id}")
    Call<Result> changePlaylistDetails(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body);

    default Call<Result> changePlaylistDetails(String playlistUri, Map<String, Object> body) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return changePlaylistDetails(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), body);
    }

    /**
     * Add the current user as a follower of a playlist.
     *
     * @param userId     The Spotify user ID of the user who owns the playlist.
     * @param playlistId The Spotify ID of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-playlist/">Follow a Playlist</a>
     */
    @PUT("users/{user_id}/playlists/{playlist_id}/followers")
    Call<Result> followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);

    default Call<Result> followPlaylist(String playlistUri) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return followPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId());
    }

    /**
     * Add the current user as a follower of a playlist.
     *
     * @param userId                The Spotify user ID of the user who owns the playlist.
     * @param playlistId            The Spotify ID of the playlist
     * @param playlistFollowPrivacy The privacy state of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-playlist/">Follow a Playlist</a>
     */
    @PUT("users/{user_id}/playlists/{playlist_id}/followers")
    Call<Result> followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body PlaylistFollowPrivacy playlistFollowPrivacy);

    default Call<Result> followPlaylist(String playlistUri, PlaylistFollowPrivacy playlistFollowPrivacy) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return followPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), playlistFollowPrivacy);
    }

    /**
     * Unfollow a Playlist
     *
     * @param userId     The Spotify user ID of the user who owns the playlist.
     * @param playlistId The Spotify ID of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/unfollow-playlist/">Unfollow a Playlist</a>
     */
    @DELETE("users/{user_id}/playlists/{playlist_id}/followers")
    Call<Result> unfollowPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);

    default Call<Result> unfollowPlaylist(String playlistUri) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return unfollowPlaylist(spotifyUri.getUserId(), spotifyUri.getPlaylistId());
    }

    /**
     * Reorder a Playlist's tracks
     *
     * @param userId     The Spotify user ID of the user who owns the playlist.
     * @param playlistId The Spotify ID of the playlist
     * @param body       The body parameters. For list of supported parameters see <a href="https://developer.spotify.com/web-api/reorder-playlists-tracks/">endpoint documentation</a>
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/reorder-playlists-tracks/">Reorder a Playlist</a>
     */
    @PUT("users/{user_id}/playlists/{playlist_id}/tracks")
    Call<SnapshotId> reorderPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body);

    default Call<SnapshotId> reorderPlaylistTracks(String playlistUri, Map<String, Object> body) throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri(playlistUri);
        return reorderPlaylistTracks(spotifyUri.getUserId(), spotifyUri.getPlaylistId(), body);
    }
}
