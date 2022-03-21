package de.sonallux.spotify.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Unauthorized
 */
@Getter
@Setter
@NoArgsConstructor
public class Unauthorized {
    public Error error;
}
