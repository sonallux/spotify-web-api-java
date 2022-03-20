package de.sonallux.spotify.api.apis.library;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Remove Tracks for Current User request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-modify</code>
 *
 * <h3>Response</h3>
 * <p>Track removed</p>
 */
public class RemoveTracksUserRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Remove Tracks for Current User request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A JSON array of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     */
    public RemoveTracksUserRequest(ApiClient apiClient, java.util.List<String> ids) {
        this.apiClient = apiClient;
        this.request = new Request("DELETE", "/me/tracks")
            .addBodyParameter("ids", ids)
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
