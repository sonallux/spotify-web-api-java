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
    public Paging<Artist> artists;
    public Paging<SimplifiedAudiobook> audiobooks;
    public Paging<SimplifiedEpisode> episodes;
    public Paging<SimplifiedPlaylist> playlists;
    public Paging<SimplifiedShow> shows;
    public Paging<Track> tracks;
}
