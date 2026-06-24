package de.sonallux.spotify.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.sonallux.spotify.api.authorization.ApiAuthorizationProvider;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.AuthorizationAddingInterceptor;
import de.sonallux.spotify.api.http.AuthorizedApiCall;
import lombok.NoArgsConstructor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.jspecify.annotations.Nullable;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.json.JsonMapper;

import java.util.Objects;

@NoArgsConstructor
public class SpotifyWebApiBuilder {
    private @Nullable HttpUrl baseUrl;
    private Call.@Nullable Factory callFactory;
    private @Nullable ObjectMapper objectMapper;
    private @Nullable ApiAuthorizationProvider authorizationProvider;

    public SpotifyWebApiBuilder baseUrl(String baseUrl) {
        Objects.requireNonNull(baseUrl, "baseUrl == null");
        return baseUrl(HttpUrl.get(baseUrl));
    }

    public SpotifyWebApiBuilder baseUrl(HttpUrl baseUrl) {
        this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl == null");
        return this;
    }

    public SpotifyWebApiBuilder httpClient(OkHttpClient httpClient) {
        return callFactory(Objects.requireNonNull(httpClient, "httpClient == null"));
    }

    public SpotifyWebApiBuilder callFactory(Call.Factory factory) {
        this.callFactory = Objects.requireNonNull(factory, "factory == null");
        return this;
    }

    public SpotifyWebApiBuilder objectMapper(ObjectMapper objectMapper) {
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper == null");
        return this;
    }

    public SpotifyWebApiBuilder authorization(ApiAuthorizationProvider authorizationProvider) {
        this.authorizationProvider = Objects.requireNonNull(authorizationProvider, "authorizationProvider == null");
        return this;
    }

    public SpotifyWebApi build() {
        if (baseUrl == null) {
            baseUrl = SpotifyWebApi.SPOTIFY_WEB_API_ENDPOINT;
        }

        if (callFactory == null) {
            if (authorizationProvider == null) {
                callFactory = new OkHttpClient();
            } else {
                callFactory = new OkHttpClient.Builder()
                    .addInterceptor(new AuthorizationAddingInterceptor(authorizationProvider))
                    .build();
            }
        }

        if (objectMapper == null) {
            objectMapper = createDefaultObjectMapper();
        }

        var apiClientBuilder = ApiClient.builder()
            .baseUrl(baseUrl)
            .callFactory(callFactory)
            .objectMapper(objectMapper);

        if (authorizationProvider != null) {
            apiClientBuilder.apiCallFactory(new AuthorizedApiCall.Factory(authorizationProvider));
        }

        return new SpotifyWebApi(apiClientBuilder.build());
    }

    private ObjectMapper createDefaultObjectMapper() {
        return JsonMapper.builder()
            .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
            .changeDefaultPropertyInclusion(incl -> incl
                .withValueInclusion(JsonInclude.Include.NON_NULL)
                .withContentInclusion(JsonInclude.Include.NON_NULL))
            .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .build();
    }
}
