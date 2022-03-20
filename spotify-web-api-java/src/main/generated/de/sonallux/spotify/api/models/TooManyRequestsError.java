package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class TooManyRequestsError {
    /**
     * <p>A short description of the cause of the error.</p>
     */
    public String message;
    /**
     * <p>The HTTP status code (also returned in the response header; see <a href="/documentation/web-api/#response-status-codes">Response Status Codes</a> for more information).</p>
     */
    public int status;
}
