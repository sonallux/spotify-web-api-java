package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * TooManyRequests
 */
@Getter
@Setter
@NoArgsConstructor
public class TooManyRequests {
    public Error error;
}
