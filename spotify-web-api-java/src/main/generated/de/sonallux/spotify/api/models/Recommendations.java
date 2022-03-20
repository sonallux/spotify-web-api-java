package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * RecommendationsObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Recommendations {
    /**
     * <p>An array of recommendation seed objects.</p>
     */
    public java.util.List<RecommendationSeed> seeds;
    /**
     * <p>An array of track objects ordered according to the parameters supplied.</p>
     */
    public java.util.List<Track> tracks;
}
