package de.sonallux.spotify.api.apis.tracks;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Save Tracks for Current User request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-modify</code>
 *
 * <h3>Response</h3>
 * <p>Track saved</p>
 * @deprecated see <a href="https://developer.spotify.com/community">the latest blog posts from Spotify</a>
 */
@Deprecated
@NullMarked
public class SaveTracksUserRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Save Tracks for Current User request
     * @param apiClient <p>The API client</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>timestamped_ids</code> is present in the body, any IDs listed in the query parameters (deprecated) or the <code>ids</code> field in the body will be ignored.</em></p>
     */
    public SaveTracksUserRequest(ApiClient apiClient, java.util.List<String> ids) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/me/tracks")
            .addBodyParameter("ids", ids)
        ;
    }

    /**
     * @param timestampedIds <p>A JSON array of objects containing track IDs with their corresponding timestamps. Each object must include a track ID and an <code>added_at</code> timestamp. This allows you to specify when tracks were added to maintain a specific chronological order in the user's library.<br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>timestamped_ids</code> is present in the body, any IDs listed in the query parameters (deprecated) or the <code>ids</code> field in the body will be ignored.</em></p>
     * @return this request
     */
    public SaveTracksUserRequest timestampedIds(java.util.List<java.util.Map<String, Object>> timestampedIds) {
        this.request.addBodyParameter("timestamped_ids", timestampedIds);
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
