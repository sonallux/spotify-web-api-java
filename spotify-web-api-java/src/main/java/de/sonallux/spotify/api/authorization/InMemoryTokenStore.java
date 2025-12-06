package de.sonallux.spotify.api.authorization;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;

/**
 * A simple {@link TokenStore} that stores the auth tokens in memory
 */
@NoArgsConstructor
@AllArgsConstructor
public class InMemoryTokenStore implements TokenStore {
    private @Nullable AuthTokens authTokens = null;

    @Override
    public void storeTokens(AuthTokens authTokens) {
        this.authTokens = authTokens;
    }

    @Override
    public AuthTokens loadTokens() {
        if (this.authTokens == null) {
            return new AuthTokens();
        }
        return this.authTokens;
    }
}
