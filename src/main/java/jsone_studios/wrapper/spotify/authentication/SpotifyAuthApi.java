package jsone_studios.wrapper.spotify.authentication;

import jsone_studios.wrapper.spotify.models.AuthTokens;
import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Base64;
import java.util.List;

public class SpotifyAuthApi
{
    public static final String SPOTIFY_ACCOUNTS_ENDPOINT = "https://accounts.spotify.com";

    private final AuthSpotifyService authService;

    public SpotifyAuthApi()
    {
        this.authService = createAuthService();
    }

    private AuthSpotifyService createAuthService()
    {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SPOTIFY_ACCOUNTS_ENDPOINT)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
        return retrofit.create(AuthSpotifyService.class);
    }

    public HttpUrl getAuthorizeUrl(String clientId, String responseType, String redirectUri, String state, List<Scope> scopes)
    {
        String scope;
        if (scopes == null || scopes.size() == 0)
        {
            scope = "";
        }
        else
        {
            scope = scopes.stream().map(Scope::getScope).reduce((scope1, scope2) -> scope1 + " " + scope2).get();
        }

        return new HttpUrl.Builder()
            .scheme("https")
            .host("accounts.spotify.com")
            .addPathSegment("authorize")
            .addQueryParameter("client_id", clientId)
            .addQueryParameter("response_type", responseType)
            .addEncodedQueryParameter("redirect_uri", redirectUri)
            .addQueryParameter("scope", scope)
            .addQueryParameter("state", state)
            .build();
    }

    public Call<AuthTokens> getAuthTokensFromAuthCode(String code, String redirectUri, String clientId, String clientSecret)
    {
        String authHeader = getAuthorizationHeaderValue(clientId, clientSecret);
        return authService.getAuthTokens(authHeader, "authorization_code", code, redirectUri);
    }

    public Call<AuthTokens> getAuthTokensFromRefreshToken(String refreshToken, String clientId, String clientSecret)
    {
        String authHeader = getAuthorizationHeaderValue(clientId, clientSecret);
        return authService.getAuthTokens(authHeader, "refresh_token", refreshToken);
    }

    private String getAuthorizationHeaderValue(String clientId, String clientSecret)
    {
        String clientInfo = clientId + ":" + clientSecret;
        String base64ClientInfo = Base64.getEncoder().encodeToString(clientInfo.getBytes());
        return "Basic " + base64ClientInfo;
    }

    public RedirectResponse parseRedirectResponse(String url)
    {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl == null)
        {
            return null;
        }
        String state = httpUrl.queryParameter("state");
        String error = httpUrl.queryParameter("error");
        String authCode = httpUrl.queryParameter("code");

        return new RedirectResponse(state, error, authCode);
    }

    public class RedirectResponse
    {
        private final String state;
        private final String error;
        private final String authCode;

        private RedirectResponse(String state, String error, String authCode)
        {
            this.state = state;
            this.error = error;
            this.authCode = authCode;
        }

        public String getState()
        {
            return state;
        }

        public String getError()
        {
            return error;
        }

        public String getAuthCode()
        {
            return authCode;
        }
    }
}
