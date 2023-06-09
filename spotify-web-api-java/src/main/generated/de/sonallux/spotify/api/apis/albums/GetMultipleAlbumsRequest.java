package de.sonallux.spotify.api.apis.albums;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Several Albums request</h2>
 *
 * <h3>Response</h3>
 * <p>A set of albums</p>
 */
public class GetMultipleAlbumsRequest {
    private static final TypeReference<ManyAlbums> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Several Albums request
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the albums. Maximum: 20 IDs.</p>
     */
    public GetMultipleAlbumsRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/albums")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br/>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br/><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br/>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetMultipleAlbumsRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<ManyAlbums> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
