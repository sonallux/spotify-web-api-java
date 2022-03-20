package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Category's Playlists request
 *
 * <h3>Response</h3>
 * <p>A paged set of playlists</p>
 */
public class GetCategoriesPlaylistsRequest {
    private static final TypeReference<PagedPlaylists> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Category's Playlists request</h3>
     * @param apiClient <p>The API client</p>
     * @param categoryId <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify category ID</a> for the category.</p>
     */
    public GetCategoriesPlaylistsRequest(ApiClient apiClient, String categoryId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/browse/categories/{category_id}/playlists")
            .addPathParameter("category_id", String.valueOf(categoryId))
        ;
    }

    /**
     * <p>A country: an <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. Provide this parameter to ensure that the category exists for a particular country.</p>
     */
    public GetCategoriesPlaylistsRequest country(String country) {
        this.request.addQueryParameter("country", String.valueOf(country));
        return this;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetCategoriesPlaylistsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetCategoriesPlaylistsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<PagedPlaylists> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
