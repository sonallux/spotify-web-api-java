package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * BadRequest
 */
@Getter
@Setter
@NoArgsConstructor
public class BadRequest {
    public Error error;
}
