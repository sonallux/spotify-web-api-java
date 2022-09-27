package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * AudiobookObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Audiobook extends AudiobookBase {
    /**
     * <p>The chapters of the audiobook.</p>
     */
    public Paging<SimplifiedChapter> chapters;
}
