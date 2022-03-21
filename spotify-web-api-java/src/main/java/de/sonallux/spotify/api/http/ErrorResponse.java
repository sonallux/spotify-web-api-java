package de.sonallux.spotify.api.http;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    public de.sonallux.spotify.api.models.Error error;
}
