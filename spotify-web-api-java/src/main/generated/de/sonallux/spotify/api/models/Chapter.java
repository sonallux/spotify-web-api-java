package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ChapterObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Chapter extends ChapterBase {
    public AudiobookBase audiobook;
}
