package de.sonallux.spotify.api.apis.artists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Artist's Albums request</h2>
 *
 * <h3>Response</h3>
 * <p>Pages of albums</p>
 */
public class GetArtistsAlbumsRequest {
    private static final TypeReference<Paging<SimplifiedAlbum>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Artist's Albums request
     * @param apiClient <p>The API client</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the artist.</p>
     */
    public GetArtistsAlbumsRequest(ApiClient apiClient, String id) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/artists/{id}/albums")
            .addPathParameter("id", String.valueOf(id))
        ;
    }

    /**
     * @param includeGroups <p>A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types will be returned. <br/>Valid values are:<br/>- <code>album</code><br/>- <code>single</code><br/>- <code>appears_on</code><br/>- <code>compilation</code><br/>For example: <code>include_groups=album,single</code>.</p>
     * @return this request
     */
    public GetArtistsAlbumsRequest includeGroups(String includeGroups) {
        this.request.addQueryParameter("include_groups", String.valueOf(includeGroups));
        return this;
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br/>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br/><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br/>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetArtistsAlbumsRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetArtistsAlbumsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     * @return this request
     */
    public GetArtistsAlbumsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Paging<SimplifiedAlbum>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
