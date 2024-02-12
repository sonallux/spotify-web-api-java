package de.sonallux.spotify.api.apis.categories;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Several Browse Categories request</h2>
 *
 * <h3>Response</h3>
 * <p>A paged set of categories</p>
 */
public class GetCategoriesRequest {
    private static final TypeReference<PagedCategories> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Several Browse Categories request
     * @param apiClient <p>The API client</p>
     */
    public GetCategoriesRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/browse/categories")
        ;
    }

    /**
     * @param locale <p>The desired language, consisting of an <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> language code and an <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>, joined by an underscore. For example: <code>es_MX</code>, meaning &quot;Spanish (Mexico)&quot;. Provide this parameter if you want the category strings returned in a particular language.<br/> <em><strong>Note</strong>: if <code>locale</code> is not supplied, or if the specified language is not available, the category strings returned will be in the Spotify default language (American English).</em></p>
     * @return this request
     */
    public GetCategoriesRequest locale(String locale) {
        this.request.addQueryParameter("locale", String.valueOf(locale));
        return this;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetCategoriesRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     * @return this request
     */
    public GetCategoriesRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<PagedCategories> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
