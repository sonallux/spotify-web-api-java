package de.sonallux.spotify.api.apis.albums;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Album Tracks request
 *
 * <h3>Response</h3>
 * <p>Pages of tracks</p>
 */
public class GetAlbumsTracksRequest {
    private static final TypeReference<Paging<SimplifiedTrack>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Album Tracks request</h3>
     * @param apiClient <p>The API client</p>
     * @param id <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the album.</p>
     */
    public GetAlbumsTracksRequest(ApiClient apiClient, String id) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/albums/{id}/tracks")
            .addPathParameter("id", String.valueOf(id))
        ;
    }

    /**
     * <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     */
    public GetAlbumsTracksRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetAlbumsTracksRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetAlbumsTracksRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Paging<SimplifiedTrack>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
