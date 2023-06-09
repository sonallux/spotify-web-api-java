package de.sonallux.spotify.api.apis.albums;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get User's Saved Albums request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-read</code>
 *
 * <h3>Response</h3>
 * <p>Pages of albums</p>
 */
public class GetUsersSavedAlbumsRequest {
    private static final TypeReference<Paging<SavedAlbum>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get User's Saved Albums request
     * @param apiClient <p>The API client</p>
     */
    public GetUsersSavedAlbumsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/albums")
        ;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetUsersSavedAlbumsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     * @return this request
     */
    public GetUsersSavedAlbumsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br/>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br/><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br/>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetUsersSavedAlbumsRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Paging<SavedAlbum>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
