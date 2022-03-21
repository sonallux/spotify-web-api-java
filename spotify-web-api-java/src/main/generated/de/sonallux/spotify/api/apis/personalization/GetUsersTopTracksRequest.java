package de.sonallux.spotify.api.apis.personalization;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get User's Top Tracks request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-top-read</code>
 *
 * <h3>Response</h3>
 * <p>Pages of tracks</p>
 */
public class GetUsersTopTracksRequest {
    private static final TypeReference<Paging<Track>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get User's Top Tracks request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetUsersTopTracksRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/top/tracks")
        ;
    }

    /**
     * <p>Over what time frame the affinities are computed. Valid values: <code>long_term</code> (calculated from several years of data and including all new data as it becomes available), <code>medium_term</code> (approximately last 6 months), <code>short_term</code> (approximately last 4 weeks). Default: <code>medium_term</code></p>
     */
    public GetUsersTopTracksRequest timeRange(String timeRange) {
        this.request.addQueryParameter("time_range", String.valueOf(timeRange));
        return this;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetUsersTopTracksRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetUsersTopTracksRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Paging<Track>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
