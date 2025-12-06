package de.sonallux.spotify.api.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jspecify.annotations.Nullable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokens {
    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("token_type")
    public String tokenType;

    public @Nullable String scope;

    @JsonProperty("expires_in")
    public int expiresIn;

    @JsonProperty("refresh_token")
    public @Nullable String refreshToken;
}
