package de.sonallux.spotify.api.apis.library;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-shows-user">Remove User's Saved Shows request</a>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-modify</code>
 *
 * <h3>Response</h3>
 * <p>On success, the HTTP status code in the response header is <code>200</code> OK.
 * On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>. A <code>403 Forbidden</code> while trying to add a show when you do not have the user's authorisation.</p>
 */
public class RemoveShowsUserRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Remove User's Saved Shows request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>.<br>A maximum of 50 items can be specified in one request. <em>Note: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     */
    public RemoveShowsUserRequest(ApiClient apiClient, java.util.List<String> ids) {
        this.apiClient = apiClient;
        this.request = new Request("DELETE", "/me/shows")
            .addBodyParameter("ids", ids)
        ;
    }

    /**
     * <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only episodes that are available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     */
    public RemoveShowsUserRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
