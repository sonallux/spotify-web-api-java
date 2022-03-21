package de.sonallux.spotify.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TooManyRequests
 */
@Getter
@Setter
@NoArgsConstructor
public class TooManyRequests {
    public Error error;
}
