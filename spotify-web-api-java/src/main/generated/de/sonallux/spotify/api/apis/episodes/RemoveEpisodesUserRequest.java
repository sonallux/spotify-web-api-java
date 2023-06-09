package de.sonallux.spotify.api.apis.episodes;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Remove User's Saved Episodes request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-modify</code>
 *
 * <h3>Response</h3>
 * <p>Episode removed</p>
 */
public class RemoveEpisodesUserRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Remove User's Saved Episodes request
     * @param apiClient <p>The API client</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. <br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     */
    public RemoveEpisodesUserRequest(ApiClient apiClient, java.util.List<String> ids) {
        this.apiClient = apiClient;
        this.request = new Request("DELETE", "/me/episodes")
            .addBodyParameter("ids", ids)
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
