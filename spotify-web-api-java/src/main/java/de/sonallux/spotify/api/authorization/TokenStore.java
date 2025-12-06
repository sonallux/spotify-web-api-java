package de.sonallux.spotify.api.authorization;

import org.jspecify.annotations.Nullable;

public interface TokenStore {
    void storeTokens(AuthTokens authTokens);
    @Nullable AuthTokens loadTokens();
}
