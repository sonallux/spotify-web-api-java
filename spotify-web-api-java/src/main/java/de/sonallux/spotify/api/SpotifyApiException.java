package de.sonallux.spotify.api;

import de.sonallux.spotify.api.models.Error;
import lombok.Getter;
import org.jspecify.annotations.Nullable;

import java.io.IOException;

public class SpotifyApiException extends IOException {

    @Getter
    private @Nullable Error error;

    public SpotifyApiException(Error error) {
        super(error.getStatus() + " " + error.getMessage());
        this.error = error;
    }

    public SpotifyApiException(String message) {
        super(message);
    }

    public SpotifyApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotifyApiException(String message, Error error) {
        super(message + ": " + error.getStatus() + " " + error.getMessage());
        this.error = error;
    }
}
