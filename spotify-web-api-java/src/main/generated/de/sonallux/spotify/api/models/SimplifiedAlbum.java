package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#object-albumbase">SimplifiedAlbumObject</a>
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class SimplifiedAlbum extends BaseObject {
    /**
     * <p>The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.</p>
     */
    public String albumGroup;
    /**
     * <p>The type of the album.</p>
     */
    public String albumType;
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<SimplifiedArtist> artists;
    /**
     * <p>The markets in which the album is available: <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country codes</a>. Note that an album is considered available in a market when at least 1 of its tracks is available in that market.</p>
     */
    public java.util.List<String> availableMarkets;
    /**
     * <p>Known external URLs for this album.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>The cover art for the album in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>The name of the album. In case of an album takedown, the value may be an empty string.</p>
     */
    public String name;
    /**
     * <p>The date the album was first released.</p>
     */
    public String releaseDate;
    /**
     * <p>The precision with which <code>release_date</code> value is known.</p>
     */
    public String releaseDatePrecision;
    /**
     * <p>Included in the response when a content restriction is applied.</p>
     */
    public AlbumRestriction restrictions;
    /**
     * <p>The number of tracks in the album.</p>
     */
    public int totalTracks;
}
