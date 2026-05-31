package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.library.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Library
 */
@NullMarked
@RequiredArgsConstructor
public class LibraryApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Items</h4>
     * <p>Check if one or more items are already saved in the current user's library. Accepts Spotify URIs for tracks, albums, episodes, shows, audiobooks, artists, users, and playlists.</p>
     * @param uris <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a>. Maximum: 40 URIs.</p><p>Supported URI types:</p><ul><li><code>spotify:track:{id}</code></li><li><code>spotify:album:{id}</code></li><li><code>spotify:episode:{id}</code></li><li><code>spotify:show:{id}</code></li><li><code>spotify:audiobook:{id}</code></li><li><code>spotify:artist:{id}</code></li><li><code>spotify:user:{id}</code></li><li><code>spotify:playlist:{id}</code></li></ul>
     * @return a {@link CheckLibraryContainsRequest} object to build and execute the request
     */
    public CheckLibraryContainsRequest checkLibraryContains(String uris) {
        return new CheckLibraryContainsRequest(apiClient, uris);
    }

    /**
     * <h4>Remove Items from Library</h4>
     * <p>Remove one or more items from the current user's library. Accepts Spotify URIs for tracks, albums, episodes, shows, audiobooks, users, and playlists.</p>
     * @param uris <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a>. Maximum: 40 URIs.</p><p>Supported URI types:</p><ul><li><code>spotify:track:{id}</code></li><li><code>spotify:album:{id}</code></li><li><code>spotify:episode:{id}</code></li><li><code>spotify:show:{id}</code></li><li><code>spotify:audiobook:{id}</code></li><li><code>spotify:user:{id}</code></li><li><code>spotify:playlist:{id}</code></li></ul>
     * @return a {@link RemoveLibraryItemsRequest} object to build and execute the request
     */
    public RemoveLibraryItemsRequest removeLibraryItems(String uris) {
        return new RemoveLibraryItemsRequest(apiClient, uris);
    }

    /**
     * <h4>Save Items to Library</h4>
     * <p>Add one or more items to the current user's library. Accepts Spotify URIs for tracks, albums, episodes, shows, audiobooks, users, and playlists.</p>
     * @param uris <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a>. Maximum: 40 URIs.</p><p>Supported URI types:</p><ul><li><code>spotify:track:{id}</code></li><li><code>spotify:album:{id}</code></li><li><code>spotify:episode:{id}</code></li><li><code>spotify:show:{id}</code></li><li><code>spotify:audiobook:{id}</code></li><li><code>spotify:user:{id}</code></li><li><code>spotify:playlist:{id}</code></li></ul>
     * @return a {@link SaveLibraryItemsRequest} object to build and execute the request
     */
    public SaveLibraryItemsRequest saveLibraryItems(String uris) {
        return new SaveLibraryItemsRequest(apiClient, uris);
    }
}
