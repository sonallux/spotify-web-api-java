package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SearchItems
 */
@Getter
@Setter
@NoArgsConstructor
public class SearchItems {
    public Paging<SimplifiedAlbum> albums;
    public Paging<SimplifiedArtist> artists;
    public Paging<SimplifiedAudiobook> audiobooks;
    public Paging<SimplifiedEpisode> episodes;
    public Paging playlists;
    public Paging<SimplifiedShow> shows;
    public Paging<SimplifiedTrack> tracks;
}
