package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.playlists.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Playlists
 */
@NullMarked
@RequiredArgsConstructor
public class PlaylistsApi {
    private final ApiClient apiClient;

    /**
     * <h4>Add Items to Playlist</h4>
     * <p>Add one or more items to a user's playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a> to add. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;,&quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;, &quot;spotify:episode:512ojhOuo1ktJprKbVcKyQ&quot;]}</code><br/>A maximum of 100 items can be added in one request. <em><strong>Note</strong>: if the <code>uris</code> parameter is present in the query string, any URIs listed here in the body will be ignored.</em></p>
     * @param position <p>The position to insert the items, a zero-based index. For example, to insert the items in the first position: <code>position=0</code> ; to insert the items in the third position: <code>position=2</code>. If omitted, the items will be appended to the playlist. Items are added in the order they appear in the uris array. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;,&quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;], &quot;position&quot;: 3}</code></p>
     * @return a {@link AddItemsToPlaylistRequest} object to build and execute the request
     */
    public AddItemsToPlaylistRequest addItemsToPlaylist(String playlistId, java.util.List<String> uris, int position) {
        return new AddItemsToPlaylistRequest(apiClient, playlistId, uris, position);
    }

    /**
     * <h4>Add Items to Playlist [DEPRECATED]</h4>
     * <p><strong>Deprecated:</strong> Use <a href="https://developer.spotify.com/documentation/web-api/reference/add-items-to-playlist">Add Items to Playlist</a> instead.</p><p>Add one or more items to a user's playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a> to add. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;,&quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;, &quot;spotify:episode:512ojhOuo1ktJprKbVcKyQ&quot;]}</code><br/>A maximum of 100 items can be added in one request. <em><strong>Note</strong>: if the <code>uris</code> parameter is present in the query string, any URIs listed here in the body will be ignored.</em></p>
     * @return a {@link AddTracksToPlaylistRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public AddTracksToPlaylistRequest addTracksToPlaylist(String playlistId, java.util.List<String> uris) {
        return new AddTracksToPlaylistRequest(apiClient, playlistId, uris);
    }

    /**
     * <h4>Change Playlist Details</h4>
     * <p>Change a playlist's name and public/private state. (The user must, of course, own the playlist.)</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link ChangePlaylistDetailsRequest} object to build and execute the request
     */
    public ChangePlaylistDetailsRequest changePlaylistDetails(String playlistId) {
        return new ChangePlaylistDetailsRequest(apiClient, playlistId);
    }

    /**
     * <h4>Create Playlist</h4>
     * <p>Create a playlist for the current Spotify user. (The playlist will be empty until you <a href="https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist">add tracks</a>.) Each user is generally limited to a maximum of 11000 playlists.</p>
     * @param name <p>The name for the new playlist, for example <code>&quot;Your Coolest Playlist&quot;</code>. This name does not need to be unique; a user may have several playlists with the same name.</p>
     * @return a {@link CreatePlaylistRequest} object to build and execute the request
     */
    public CreatePlaylistRequest createPlaylist(String name) {
        return new CreatePlaylistRequest(apiClient, name);
    }

    /**
     * <h4>Create Playlist for user</h4>
     * <p><strong>Deprecated</strong>: Use <a href="https://developer.spotify.com/documentation/web-api/reference/create-playlist">Create Playlist</a> instead.</p><p>Create a playlist for a Spotify user. (The playlist will be empty until you <a href="https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist">add tracks</a>.) Each user is generally limited to a maximum of 11000 playlists.</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify user ID</a>.</p>
     * @param name <p>The name for the new playlist, for example <code>&quot;Your Coolest Playlist&quot;</code>. This name does not need to be unique; a user may have several playlists with the same name.</p>
     * @return a {@link CreatePlaylistForUserRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public CreatePlaylistForUserRequest createPlaylistForUser(String userId, String name) {
        return new CreatePlaylistForUserRequest(apiClient, userId, name);
    }

    /**
     * <h4>Get Category's Playlists</h4>
     * <p>Get a list of Spotify playlists tagged with a particular category.</p>
     * @param categoryId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify category ID</a> for the category.</p>
     * @return a {@link GetCategoriesPlaylistsRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetCategoriesPlaylistsRequest getCategoriesPlaylists(String categoryId) {
        return new GetCategoriesPlaylistsRequest(apiClient, categoryId);
    }

    /**
     * <h4>Get Featured Playlists</h4>
     * <p>Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).</p>
     * @return a {@link GetFeaturedPlaylistsRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetFeaturedPlaylistsRequest getFeaturedPlaylists() {
        return new GetFeaturedPlaylistsRequest(apiClient);
    }

    /**
     * <h4>Get Current User's Playlists</h4>
     * <p>Get a list of the playlists owned or followed by the current Spotify user.</p>
     * @return a {@link GetListOfCurrentUsersPlaylistsRequest} object to build and execute the request
     */
    public GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylists() {
        return new GetListOfCurrentUsersPlaylistsRequest(apiClient);
    }

    /**
     * <h4>Get User's Playlists</h4>
     * <p>Get a list of the playlists owned or followed by a Spotify user.</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify user ID</a>.</p>
     * @return a {@link GetListUsersPlaylistsRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetListUsersPlaylistsRequest getListUsersPlaylists(String userId) {
        return new GetListUsersPlaylistsRequest(apiClient, userId);
    }

    /**
     * <h4>Get Playlist</h4>
     * <p>Get a playlist owned by a Spotify user.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link GetPlaylistRequest} object to build and execute the request
     */
    public GetPlaylistRequest getPlaylist(String playlistId) {
        return new GetPlaylistRequest(apiClient, playlistId);
    }

    /**
     * <h4>Get Playlist Cover Image</h4>
     * <p>Get the current image associated with a specific playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link GetPlaylistCoverRequest} object to build and execute the request
     */
    public GetPlaylistCoverRequest getPlaylistCover(String playlistId) {
        return new GetPlaylistCoverRequest(apiClient, playlistId);
    }

    /**
     * <h4>Get Playlist Items</h4>
     * <p>Get full details of the items of a playlist owned by a Spotify user.</p><p><strong>Note</strong>: This endpoint is only accessible for playlists owned by the current user or playlists the user is a collaborator of. A <code>403 Forbidden</code> status code will be returned if the user is neither the owner nor a collaborator of the playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link GetPlaylistsItemsRequest} object to build and execute the request
     */
    public GetPlaylistsItemsRequest getPlaylistsItems(String playlistId) {
        return new GetPlaylistsItemsRequest(apiClient, playlistId);
    }

    /**
     * <h4>Get Playlist Items [DEPRECATED]</h4>
     * <p><strong>Deprecated:</strong> Use <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlists-items">Get Playlist Items</a> instead.</p><p>Get full details of the items of a playlist owned by a Spotify user.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link GetPlaylistsTracksRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetPlaylistsTracksRequest getPlaylistsTracks(String playlistId) {
        return new GetPlaylistsTracksRequest(apiClient, playlistId);
    }

    /**
     * <h4>Remove Playlist Items</h4>
     * <p>Remove one or more items from a user's playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param items <p>An array of objects containing <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a> of the tracks or episodes to remove. For example: <code>{ &quot;items&quot;: [{ &quot;uri&quot;: &quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot; },{ &quot;uri&quot;: &quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot; }] }</code>. A maximum of 100 objects can be sent at once.</p>
     * @return a {@link RemoveItemsPlaylistRequest} object to build and execute the request
     */
    public RemoveItemsPlaylistRequest removeItemsPlaylist(String playlistId, java.util.List<java.util.Map<String, Object>> items) {
        return new RemoveItemsPlaylistRequest(apiClient, playlistId, items);
    }

    /**
     * <h4>Remove Playlist Items [DEPRECATED]</h4>
     * <p><strong>Deprecated:</strong> Use <a href="https://developer.spotify.com/documentation/web-api/reference/remove-items-playlist">Remove Playlist Items</a> instead.</p><p>Remove one or more items from a user's playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param tracks <p>An array of objects containing <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a> of the tracks or episodes to remove. For example: <code>{ &quot;tracks&quot;: [{ &quot;uri&quot;: &quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot; },{ &quot;uri&quot;: &quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot; }] }</code>. A maximum of 100 objects can be sent at once.</p>
     * @return a {@link RemoveTracksPlaylistRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public RemoveTracksPlaylistRequest removeTracksPlaylist(String playlistId, java.util.List<java.util.Map<String, Object>> tracks) {
        return new RemoveTracksPlaylistRequest(apiClient, playlistId, tracks);
    }

    /**
     * <h4>Update Playlist Items</h4>
     * <p>Either reorder or replace items in a playlist depending on the request's parameters. To reorder items, include <code>range_start</code>, <code>insert_before</code>, <code>range_length</code> and <code>snapshot_id</code> in the request's body. To replace items, include <code>uris</code> as either a query parameter or in the request's body. Replacing items in a playlist will overwrite its existing items. This operation can be used for replacing or clearing items in a playlist. <br/><strong>Note</strong>: Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters. These operations can't be applied together in a single request.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris 
     * @return a {@link ReorderOrReplacePlaylistsItemsRequest} object to build and execute the request
     */
    public ReorderOrReplacePlaylistsItemsRequest reorderOrReplacePlaylistsItems(String playlistId, java.util.List<String> uris) {
        return new ReorderOrReplacePlaylistsItemsRequest(apiClient, playlistId, uris);
    }

    /**
     * <h4>Reorder Playlist Items</h4>
     * <p>Reorder items in a playlist</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param rangeStart <p>The position of the first item to be reordered.</p>
     * @param insertBefore <p>The position where the items should be inserted.<br/>To reorder the items to the end of the playlist, simply set <em>insert_before</em> to the position after the last item.<br/>Examples:<br/>To reorder the first item to the last position in a playlist with 10 items, set <em>range_start</em> to 0, and <em>insert_before</em> to 10.<br/>To reorder the last item in a playlist with 10 items to the start of the playlist, set <em>range_start</em> to 9, and <em>insert_before</em> to 0.</p>
     * @return a {@link ReorderPlaylistsTracksRequest} object to build and execute the request
     */
    public ReorderPlaylistsTracksRequest reorderPlaylistsTracks(String playlistId, int rangeStart, int insertBefore) {
        return new ReorderPlaylistsTracksRequest(apiClient, playlistId, rangeStart, insertBefore);
    }

    /**
     * <h4>Replace Playlist Items</h4>
     * <p>Replacing items in a playlist will overwrite its existing items. This operation can be used for replacing or clearing items in a playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris 
     * @return a {@link ReplacePlaylistsTracksRequest} object to build and execute the request
     */
    public ReplacePlaylistsTracksRequest replacePlaylistsTracks(String playlistId, java.util.List<String> uris) {
        return new ReplacePlaylistsTracksRequest(apiClient, playlistId, uris);
    }

    /**
     * <h4>Add Custom Playlist Cover Image</h4>
     * <p>Replace the image used to represent a specific playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param base64Image <p>Base64 encoded JPEG image data, maximum payload size is 256 KB.</p>
     * @return a {@link UploadCustomPlaylistCoverRequest} object to build and execute the request
     */
    public UploadCustomPlaylistCoverRequest uploadCustomPlaylistCover(String playlistId, String base64Image) {
        return new UploadCustomPlaylistCoverRequest(apiClient, playlistId, base64Image);
    }
}
