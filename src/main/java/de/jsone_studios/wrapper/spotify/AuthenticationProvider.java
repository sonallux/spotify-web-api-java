package de.jsone_studios.wrapper.spotify;

import de.jsone_studios.wrapper.spotify.models.AuthTokens;

public interface AuthenticationProvider {
    String getAccessToken();

    String getRefreshToken();

    String getClientId();

    String getClientSecret();

    void onNewAuthTokens(AuthTokens authTokens);

    void onErrorGettingAuthTokens(SpotifyApiException exception);
}
