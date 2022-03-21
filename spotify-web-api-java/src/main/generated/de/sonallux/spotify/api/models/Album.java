package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * AlbumObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Album extends AlbumBase {
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<Artist> artists;
    /**
     * <p>The copyright statements of the album.</p>
     */
    public java.util.List<Copyright> copyrights;
    /**
     * <p>Known external IDs for the album.</p>
     */
    public ExternalId externalIds;
    /**
     * <p>A list of the genres used to classify the album. (If not yet classified, the array is empty.)</p>
     */
    public java.util.List<String> genres;
    /**
     * <p>The label for the album.</p>
     */
    public String label;
    /**
     * <p>The popularity of the album, with 100 being the most popular. The popularity is calculated from the popularity of the album's individual tracks.</p>
     */
    public int popularity;
    /**
     * <p>The tracks of the album.</p>
     */
    public Paging<SimplifiedTrack> tracks;
}
