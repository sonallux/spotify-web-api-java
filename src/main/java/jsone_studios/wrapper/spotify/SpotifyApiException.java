package jsone_studios.wrapper.spotify;

import jsone_studios.wrapper.spotify.models.ErrorDetails;

import java.io.IOException;

public class SpotifyApiException extends IOException {

    private ErrorDetails error;

    public SpotifyApiException(ErrorDetails error) {
        super(error.status + " " + error.message);
        this.error = error;
    }

    public SpotifyApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotifyApiException(String message, ErrorDetails error) {
        super(message + ": " + error.status + " " + error.message);
        this.error = error;
    }

    public SpotifyApiException(String message, ErrorDetails error, Throwable cause) {
        super(message + ": " + error.status + " " + error.message, cause);
        this.error = error;
    }

    public ErrorDetails getError() {
        return error;
    }
}
