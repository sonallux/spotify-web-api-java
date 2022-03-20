package de.sonallux.spotify.api.apis.episodes;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Several Episodes request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-playback-position</code>
 *
 * <h3>Response</h3>
 * <p>A set of episodes</p>
 */
public class GetMultipleEpisodesRequest {
    private static final TypeReference<ManyEpisodes> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Several Episodes request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     */
    public GetMultipleEpisodesRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/episodes")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     */
    public GetMultipleEpisodesRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<ManyEpisodes> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
