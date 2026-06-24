package de.sonallux.spotify.api.apis.audiobooks;

import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;
import tools.jackson.core.type.TypeReference;

/**
 * <h2>Remove User's Saved Audiobooks request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-modify</code>
 *
 * <h3>Response</h3>
 * <p>Audiobook(s) have been removed from the library</p>
 * @deprecated see <a href="https://developer.spotify.com/community">the latest blog posts from Spotify</a>
 */
@Deprecated
@NullMarked
public class RemoveAudiobooksUserRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Remove User's Saved Audiobooks request
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     */
    public RemoveAudiobooksUserRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("DELETE", "/me/audiobooks")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
