package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * Forbidden
 */
@Getter
@Setter
@NoArgsConstructor
public class Forbidden {
    public ForbiddenError error;
}
