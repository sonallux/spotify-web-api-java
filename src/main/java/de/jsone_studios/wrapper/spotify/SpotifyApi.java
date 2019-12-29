package de.jsone_studios.wrapper.spotify;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.jsone_studios.wrapper.spotify.authentication.SpotifyAuthApi;
import de.jsone_studios.wrapper.spotify.models.AuthTokens;
import de.jsone_studios.wrapper.spotify.services.*;
import de.jsone_studios.wrapper.spotify.util.TextUtils;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class SpotifyApi implements SpotifyServices {
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
     * @param authCode    the authorization code returned form an authorization request
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

    @Override
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
        catch (IOException e) {
            throw new SpotifyApiException("Failed to make api call", e);
        }
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
    public Retrofit getRetrofit() {
        return this.retrofit;
    }

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
