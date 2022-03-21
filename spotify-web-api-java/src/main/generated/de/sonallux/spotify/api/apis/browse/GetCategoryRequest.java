package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Single Browse Category request
 *
 * <h3>Response</h3>
 * <p>A category</p>
 */
public class GetCategoryRequest {
    private static final TypeReference<Category> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Single Browse Category request</h3>
     * @param apiClient <p>The API client</p>
     * @param categoryId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify category ID</a> for the category.</p>
     */
    public GetCategoryRequest(ApiClient apiClient, String categoryId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/browse/categories/{category_id}")
            .addPathParameter("category_id", String.valueOf(categoryId))
        ;
    }

    /**
     * <p>A country: an <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. Provide this parameter to ensure that the category exists for a particular country.</p>
     */
    public GetCategoryRequest country(String country) {
        this.request.addQueryParameter("country", String.valueOf(country));
        return this;
    }

    /**
     * <p>The desired language, consisting of an <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> language code and an <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>, joined by an underscore. For example: <code>es_MX</code>, meaning &quot;Spanish (Mexico)&quot;. Provide this parameter if you want the category strings returned in a particular language.<br> <em><strong>Note</strong>: if <code>locale</code> is not supplied, or if the specified language is not available, the category strings returned will be in the Spotify default language (American English).</em></p>
     */
    public GetCategoryRequest locale(String locale) {
        this.request.addQueryParameter("locale", String.valueOf(locale));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Category> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
