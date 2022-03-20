package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ContextObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Context {
    /**
     * <p>External URLs for this context.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A link to the Web API endpoint providing full details of the track.</p>
     */
    public String href;
    /**
     * <p>The object type, e.g. &quot;artist&quot;, &quot;playlist&quot;, &quot;album&quot;, &quot;show&quot;.</p>
     */
    public String type;
    /**
     * <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify URI</a> for the context.</p>
     */
    public String uri;
}
