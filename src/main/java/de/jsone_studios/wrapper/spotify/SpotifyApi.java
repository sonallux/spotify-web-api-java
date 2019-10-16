package de.jsone_studios.wrapper.spotify;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.jsone_studios.wrapper.spotify.authentication.SpotifyAuthApi;
import de.jsone_studios.wrapper.spotify.models.AuthTokens;
import de.jsone_studios.wrapper.spotify.models.ErrorDetails;
import de.jsone_studios.wrapper.spotify.models.ErrorResponse;
import de.jsone_studios.wrapper.spotify.services.*;
import de.jsone_studios.wrapper.spotify.util.TextUtils;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class SpotifyApi implements SpotifyServices
{
    private final Retrofit retrofit;
    private final AuthenticationProvider authProvider;
    private final SpotifyAuthApi authApi;
    private final SpotifyWebApi webApi;

    public SpotifyApi(AuthenticationProvider authProvider, HttpUrl baseUrlWebApi, HttpUrl baseUrlAuthApi) {
        this.authProvider = authProvider;
        this.authApi = new SpotifyAuthApi(authProvider.getClientId(), authProvider.getClientSecret(), baseUrlAuthApi);
        this.retrofit = createDefaultRetrofit(baseUrlWebApi);
        this.webApi = new SpotifyWebApi(retrofit);
    }

    public SpotifyApi(AuthenticationProvider authProvider) {
        this.authProvider = authProvider;
        this.authApi = new SpotifyAuthApi(authProvider.getClientId(), authProvider.getClientSecret());
        this.retrofit = createDefaultRetrofit(HttpUrl.get(SpotifyWebApi.SPOTIFY_WEB_API_ENDPOINT));
        this.webApi = new SpotifyWebApi(retrofit);
    }

    private Retrofit createDefaultRetrofit(HttpUrl baseUrl) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .client(okHttpClient)
                .build();
    }

    public SpotifyAuthApi getAuthApi() {
        return authApi;
    }

    /**
     * Request a access-token and refresh-token from an authorization code.
     * The tokens are passed to {@link AuthenticationProvider#onNewAuthTokens(AuthTokens)}.
     *
     * @param authCode the authorization code returned form an authorization request
     * @param redirectUri the redirect URI used for the authorization request
     * @return <code>true</code> if new tokens were requested successfully, <code>false</code> otherwise
     */
    public boolean getAuthTokensFromAuthCode(String authCode, String redirectUri) {
        Call<AuthTokens> call = authApi.getAuthTokensFromAuthCode(authCode, redirectUri);
        return executeAuthTokensCall(call);
    }

    /**
     * Request a access-token and refresh-token from an existing refresh code.
     * The tokens are passed to {@link AuthenticationProvider#onNewAuthTokens(AuthTokens)}.
     *
     * @return <code>true</code> if new tokens were requested successfully, <code>false</code> otherwise
     */
    private boolean getAuthTokensFromRefreshToken() {
        String refreshToken = authProvider.getRefreshToken();
        if (TextUtils.isEmpty(refreshToken)) {
            return false;
        }
        Call<AuthTokens> call = authApi.getAuthTokensFromRefreshToken(refreshToken);
        return executeAuthTokensCall(call);
    }

    private boolean executeAuthTokensCall(Call<AuthTokens> authTokensCall) {
        try {
            AuthTokens authTokens = callApiAndReturnBody(authTokensCall);
            authProvider.onNewAuthTokens(authTokens);

            return true;
        }
        catch (SpotifyApiException e) {
            authProvider.onErrorGettingAuthTokens(e);
            return false;
        }
    }

    public <T> T callApiAndReturnBody(Call<T> call) throws SpotifyApiException {
        return getBody(callApi(call));
    }

    public <T> retrofit2.Response<T> callApi(Call<T> call) throws SpotifyApiException {
        try {
            retrofit2.Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response;
            }
            else if (response.code() == 401) { //Unauthorized
                if (getAuthTokensFromRefreshToken()) {
                    return call.clone().execute();
                }
            }
            return response;
        }
        catch (IOException e){
            throw new SpotifyApiException("Failed to make api call", e);
        }
    }

    public <T> T getBody(retrofit2.Response<T> response) throws SpotifyApiException {
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }

        throw new SpotifyApiException("Api call failed", getErrorBody(response));
    }

    private ErrorDetails getErrorBody(retrofit2.Response<?> response) throws SpotifyApiException {
        if (response.errorBody() == null) {
            throw new SpotifyApiException("Failed to get error body", getErrorDetailsFromResponse(response));
        }
        try {
            Converter<ResponseBody, ErrorResponse> converter = retrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
            ErrorResponse errorResponse = converter.convert(response.errorBody());
            if (errorResponse != null) {
                return errorResponse.error;
            }
        }
        catch (IOException ignore) {
        }
        throw new SpotifyApiException("Failed to parse error body", getErrorDetailsFromResponse(response));
    }

    private static ErrorDetails getErrorDetailsFromResponse(retrofit2.Response<?> response) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.status = response.code();
        errorDetails.message = response.message();
        return errorDetails;
    }

    private Interceptor authInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String accessToken = authProvider.getAccessToken();
            if (accessToken != null) {
                request = request.newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
            }
            return chain.proceed(request);
        }
    };

    @Override
    public AlbumsSpotifyService getAlbumsService() {
        return webApi.getAlbumsService();
    }

    @Override
    public ArtistsSpotifyService getArtistsService() {
        return webApi.getArtistsService();
    }

    @Override
    public BrowseSpotifyService getBrowseService() {
        return webApi.getBrowseService();
    }

    @Override
    public FollowSpotifyService getFollowService() {
        return webApi.getFollowService();
    }

    @Override
    public LibrarySpotifyService getLibraryService() {
        return webApi.getLibraryService();
    }

    @Override
    public PersonalizationSpotifyService getPersonalizationService() {
        return webApi.getPersonalizationService();
    }

    @Override
    public PlaylistsSpotifyService getPlaylistsService() {
        return webApi.getPlaylistsService();
    }

    @Override
    public PlaylistTracksSpotifyService getPlaylistTracksService() {
        return webApi.getPlaylistTracksService();
    }

    @Override
    public SearchSpotifyService getSearchService() {
        return webApi.getSearchService();
    }

    @Override
    public TracksSpotifyService getTracksService() {
        return webApi.getTracksService();
    }

    @Override
    public UsersProfileSpotifyService getUsersProfileService() {
        return webApi.getUsersProfileService();
    }
}
