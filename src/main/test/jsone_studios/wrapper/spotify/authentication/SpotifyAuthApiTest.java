package jsone_studios.wrapper.spotify.authentication;

import okhttp3.HttpUrl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SpotifyAuthApiTest
{
    private SpotifyAuthApi authApi;

    @Before
    public void setup()
    {
        this.authApi = new SpotifyAuthApi("1a2b3c4d5e6f7", "bar456");
    }

    @Test
    public void testGetAuthorizeUrl()
    {
        HttpUrl expectedUrl = HttpUrl.parse("https://accounts.spotify.com/authorize?client_id=1a2b3c4d5e6f7&response_type=code&redirect_uri=https://example.com/callback&scope=user-read-private user-read-email&state=34fFs29kd10");
        HttpUrl realUrl = authApi.getAuthorizeUrl("code", "https://example.com/callback",
                "34fFs29kd10", Arrays.asList(Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL));

        Assert.assertEquals(expectedUrl, realUrl);
    }

    @Test
    public void testParseRedirectResponseSuccess()
    {
        SpotifyAuthApi.RedirectResponse redirectResponse = authApi.parseRedirectResponse("https://example.com/callback?code=NApCCgBkWtQ&state=profile%2Factivity");
        Assert.assertNotNull(redirectResponse);
        Assert.assertNull(redirectResponse.getError());
        Assert.assertEquals("profile/activity", redirectResponse.getState());
        Assert.assertEquals("NApCCgBkWtQ", redirectResponse.getAuthCode());
    }

    @Test
    public void testParseRedirectResponseFail()
    {
        SpotifyAuthApi.RedirectResponse redirectResponse = authApi.parseRedirectResponse("https://example.com/callback?error=access_denied&state=STATE");
        Assert.assertNotNull(redirectResponse);
        Assert.assertNull(redirectResponse.getAuthCode());
        Assert.assertEquals("STATE", redirectResponse.getState());
        Assert.assertEquals("access_denied", redirectResponse.getError());
    }
}