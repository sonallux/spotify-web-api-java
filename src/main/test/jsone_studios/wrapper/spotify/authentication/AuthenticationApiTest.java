package jsone_studios.wrapper.spotify.authentication;

import okhttp3.HttpUrl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationApiTest
{
    private AuthenticationApi authApi;

    @Before
    public void setup()
    {
        this.authApi = new AuthenticationApi();
    }

    @Test
    public void testGetAuthorizeUrl()
    {
        HttpUrl expectedUrl = HttpUrl.parse("https://accounts.spotify.com/authorize?client_id=5fe01282e44241328a84e7c5cc169165&response_type=code&redirect_uri=https://example.com/callback&scope=user-read-private,user-read-email&state=34fFs29kd09");
        HttpUrl realUrl = authApi.getAuthorizeUrl("5fe01282e44241328a84e7c5cc169165", "code",
            "https://example.com/callback", "34fFs29kd09", "user-read-private,user-read-email");

        Assert.assertEquals(expectedUrl, realUrl);
    }

    @Test
    public void testParseRedirectResponseSuccess()
    {
        AuthenticationApi.RedirectResponse redirectResponse = authApi.parseRedirectResponse("https://example.com/callback?code=NApCCgBkWtQ&state=profile%2Factivity");
        Assert.assertNotNull(redirectResponse);
        Assert.assertNull(redirectResponse.getError());
        Assert.assertEquals("profile/activity", redirectResponse.getState());
        Assert.assertEquals("NApCCgBkWtQ", redirectResponse.getAuthCode());
    }

    @Test
    public void testParseRedirectResponseFail()
    {
        AuthenticationApi.RedirectResponse redirectResponse = authApi.parseRedirectResponse("https://example.com/callback?error=access_denied&state=STATE");
        Assert.assertNotNull(redirectResponse);
        Assert.assertNull(redirectResponse.getAuthCode());
        Assert.assertEquals("STATE", redirectResponse.getState());
        Assert.assertEquals("access_denied", redirectResponse.getError());
    }
}
