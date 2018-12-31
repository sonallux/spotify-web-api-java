package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface PlaylistTracksSpotifyService
{
    /**
     * Add tracks to a playlist
     *
     * @param playlistId      The playlist's ID
     * @param queryParameters Query parameters
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist/">Add Tracks to a Playlist</a>
     */
    @POST("playlists/{playlist_id}/tracks")
    Call<SnapshotId> addTracksToPlaylist(@Path("playlist_id") String playlistId, @QueryMap Map<String, Object> queryParameters);

    /**
     * Add tracks to a playlist
     *
     * @param playlistId  The playlist's ID
     * @param tracksToAdd The tracks to add as list of track uris
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist/">Add Tracks to a Playlist</a>
     */
    @POST("playlists/{playlist_id}/tracks")
    Call<SnapshotId> addTracksToPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistTracksToAdd tracksToAdd);

    /**
     * Add tracks to a playlist
     *
     * @param playlistId  The playlist's ID
     * @param tracksToAddWithPosition The tracks to add as list of track uris and the position to add the track
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/add-tracks-to-playlist/">Add Tracks to a Playlist</a>
     */
    @POST("playlists/{playlist_id}/tracks")
    Call<SnapshotId> addTracksToPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistTracksToAddWithPosition tracksToAddWithPosition);

    /**
     * Get full details of the tracks of a playlist owned by a Spotify user.
     *
     * @param playlistId The Spotify ID for the playlist.
     * @return List of playlist's tracks wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">Get a Playlist’s Tracks</a>
     */
    @GET("playlists/{playlist_id}/tracks")
    Call<Pager<PlaylistTrack>> getPlaylistTracks(@Path("playlist_id") String playlistId);

    /**
     * Get full details of the tracks of a playlist owned by a Spotify user.
     *
     * @param playlistId The Spotify ID for the playlist.
     * @param options    Optional parameters. For list of supported parameters see
     *                   <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">endpoint documentation</a>
     * @return List of playlist's tracks wrapped in a {@code Pager} object
     * @see <a href="https://developer.spotify.com/web-api/get-playlists-tracks/">Get a Playlist’s Tracks</a>
     */
    @GET("playlists/{playlist_id}/tracks")
    Call<Pager<PlaylistTrack>> getPlaylistTracks(@Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options);

    /**
     * Remove one or more tracks from a user’s playlist.
     *
     * @param playlistId     The playlist's Id
     * @param tracksToRemove A list of tracks to remove
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">Remove Tracks from a Playlist</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "playlists/{playlist_id}/tracks")
    Call<SnapshotId> removeTracksFromPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistTracksToRemove tracksToRemove);

    /**
     * Remove one or more tracks from a user’s playlist.
     *
     * @param playlistId                 The playlist's Id
     * @param tracksToRemoveWithPosition A list of tracks to remove, together with their specific positions
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/remove-tracks-playlist/">Remove Tracks from a Playlist</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "playlists/{playlist_id}/tracks")
    Call<SnapshotId> removeTracksFromPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistTracksToRemoveWithPosition tracksToRemoveWithPosition);

    /**
     * Replace all the tracks in a playlist, overwriting its existing tracks. This powerful request can be useful for
     * replacing tracks, re-ordering existing tracks, or clearing the playlist.
     *
     * @param playlistId The playlist's Id
     * @param trackUris  A list of comma-separated track uris
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/replace-playlists-tracks/">Replace a Playlist’s Tracks</a>
     */
    @PUT("playlists/{playlist_id}/tracks")
    Call<Result> replaceTracksInPlaylist(@Path("playlist_id") String playlistId, @Query("uris") String trackUris);

    /**
     * Replace all the tracks in a playlist, overwriting its existing tracks. This powerful request can be useful for
     * replacing tracks, re-ordering existing tracks, or clearing the playlist.
     *
     * @param playlistId The playlist's Id
     * @param newTracksToSet A list of track uris
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/replace-playlists-tracks/">Replace a Playlist’s Tracks</a>
     */
    @PUT("playlists/{playlist_id}/tracks")
    Call<Result> replaceTracksInPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistTracksToReplace newTracksToSet);

    /**
     * Reorder a Playlist's tracks
     *
     * @param playlistId The Spotify ID of the playlist
     * @param body       The body parameters. For list of supported parameters see <a href="https://developer.spotify.com/web-api/reorder-playlists-tracks/">endpoint documentation</a>
     * @return A snapshot ID (the version of the playlist)
     * @see <a href="https://developer.spotify.com/web-api/reorder-playlists-tracks/">Reorder a Playlist</a>
     */
    @PUT("playlists/{playlist_id}/tracks")
    Call<SnapshotId> reorderPlaylistTracks(@Path("playlist_id") String playlistId, @Body Map<String, Object> body);
}
