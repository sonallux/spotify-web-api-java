package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get New Releases request
 *
 * <h3>Response</h3>
 * <p>A paged set of albums</p>
 */
public class GetNewReleasesRequest {
    private static final TypeReference<PagedAlbums> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get New Releases request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetNewReleasesRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/browse/new-releases")
        ;
    }

    /**
     * <p>A country: an <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. Provide this parameter if you want the list of returned items to be relevant to a particular country. If omitted, the returned items will be relevant to all countries.</p>
     */
    public GetNewReleasesRequest country(String country) {
        this.request.addQueryParameter("country", String.valueOf(country));
        return this;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetNewReleasesRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetNewReleasesRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<PagedAlbums> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
