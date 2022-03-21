package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Several Browse Categories request
 *
 * <h3>Response</h3>
 * <p>A paged set of categories</p>
 */
public class GetCategoriesRequest {
    private static final TypeReference<PagedCategories> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Several Browse Categories request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetCategoriesRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/browse/categories")
        ;
    }

    /**
     * <p>A country: an <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. Provide this parameter if you want to narrow the list of returned categories to those relevant to a particular country. If omitted, the returned items will be globally relevant.</p>
     */
    public GetCategoriesRequest country(String country) {
        this.request.addQueryParameter("country", String.valueOf(country));
        return this;
    }

    /**
     * <p>The desired language, consisting of an <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> language code and an <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>, joined by an underscore. For example: <code>es_MX</code>, meaning &quot;Spanish (Mexico)&quot;. Provide this parameter if you want the category metadata returned in a particular language. <br><em><strong>Note</strong>: if <code>locale</code> is not supplied, or if the specified language is not available, all strings will be returned in the Spotify default language (American English). The <code>locale</code> parameter, combined with the <code>country</code> parameter, may give odd results if not carefully matched. For example <code>country=SE&amp;locale=de_DE</code> will return a list of categories relevant to Sweden but as German language strings.</em></p>
     */
    public GetCategoriesRequest locale(String locale) {
        this.request.addQueryParameter("locale", String.valueOf(locale));
        return this;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetCategoriesRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetCategoriesRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<PagedCategories> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
