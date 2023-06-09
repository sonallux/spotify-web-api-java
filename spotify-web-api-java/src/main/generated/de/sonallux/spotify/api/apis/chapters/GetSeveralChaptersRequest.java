package de.sonallux.spotify.api.apis.chapters;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Several Chapters request</h2>
 *
 * <h3>Response</h3>
 * <p>A set of chapters</p>
 */
public class GetSeveralChaptersRequest {
    private static final TypeReference<ManyChapters> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Several Chapters request
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=0IsXVP0JmcB2adSE338GkK,3ZXb8FKZGU0EHALYX6uCzU</code>. Maximum: 50 IDs.</p>
     */
    public GetSeveralChaptersRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/chapters")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br/>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br/><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br/>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetSeveralChaptersRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<ManyChapters> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
