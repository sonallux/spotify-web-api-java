package de.sonallux.spotify.api.apis.library;

import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;
import tools.jackson.core.type.TypeReference;

/**
 * <h2>Check User's Saved Items request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-read, user-follow-read, playlist-read-private</code>
 *
 * <h3>Response</h3>
 * <p>Array of booleans</p>
 */
@NullMarked
public class CheckLibraryContainsRequest {
    private static final TypeReference<java.util.List<Boolean>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Check User's Saved Items request
     * @param apiClient <p>The API client</p>
     * @param uris <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a>. Maximum: 40 URIs.</p><p>Supported URI types:</p><ul><li><code>spotify:track:{id}</code></li><li><code>spotify:album:{id}</code></li><li><code>spotify:episode:{id}</code></li><li><code>spotify:show:{id}</code></li><li><code>spotify:audiobook:{id}</code></li><li><code>spotify:artist:{id}</code></li><li><code>spotify:user:{id}</code></li><li><code>spotify:playlist:{id}</code></li></ul>
     */
    public CheckLibraryContainsRequest(ApiClient apiClient, String uris) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/library/contains")
            .addQueryParameter("uris", String.valueOf(uris))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<java.util.List<Boolean>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
