package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class Album extends BaseObject {
    /**
     * <p>The type of the album.</p>
     */
    public String albumType;
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<Artist> artists;
    /**
     * <p>The markets in which the album is available: <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country codes</a>. Note that an album is considered available in a market when at least one of its tracks is available in that market.</p>
     */
    public java.util.List<String> availableMarkets;
    /**
     * <p>The copyright statements of the album.</p>
     */
    public java.util.List<Copyright> copyrights;
    /**
     * <p>Known external IDs for the album.</p>
     */
    public ExternalId externalIds;
    /**
     * <p>Known external URLs for this album.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A list of the genres used to classify the album. (If not yet classified, the array is empty.)</p>
     */
    public java.util.List<String> genres;
    /**
     * <p>The cover art for the album in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>The label for the album.</p>
     */
    public String label;
    /**
     * <p>The name of the album. In case of an album takedown, the value may be an empty string.</p>
     */
    public String name;
    /**
     * <p>The popularity of the album, with 100 being the most popular. The popularity is calculated from the popularity of the album's individual tracks.</p>
     */
    public int popularity;
    /**
     * <p>The date the album was first released. Depending on the precision, it might be shown as &quot;1981&quot; or &quot;1981-12&quot;.</p>
     */
    public String releaseDate;
    /**
     * <p>The precision with which release_date value is known.</p>
     */
    public String releaseDatePrecision;
    /**
     * <p>Included in the response when a content restriction is applied. See <a href="https://developer.spotify.com/documentation/web-api/reference/#object-albumrestrictionobject">Restriction Object</a> for more details.</p>
     */
    public AlbumRestriction restrictions;
    /**
     * <p>The total number of tracks in the album.</p>
     */
    public int totalTracks;
    /**
     * <p>The tracks of the album.</p>
     */
    public Paging<SimplifiedTrack> tracks;
}
