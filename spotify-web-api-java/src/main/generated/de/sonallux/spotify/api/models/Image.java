package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ImageObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Image {
    /**
     * <p>The image height in pixels.</p>
     */
    public int height;
    /**
     * <p>The source URL of the image.</p>
     */
    public String url;
    /**
     * <p>The image width in pixels.</p>
     */
    public int width;
}
