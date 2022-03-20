package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * Unauthorized
 */
@Getter
@Setter
@NoArgsConstructor
public class Unauthorized {
    public UnauthorizedError error;
}
