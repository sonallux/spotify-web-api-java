package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ExternalUrlObject
 */
@Getter
@Setter
@NoArgsConstructor
public class ExternalUrl {
    /**
     * <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URL</a> for the object.</p>
     */
    public String spotify;
}
