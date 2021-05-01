package de.sonallux.spotify.api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SearchResponse {
    public Paging<SimplifiedAlbum> albums;
    public Paging<Artist> artists;
    public Paging<SimplifiedEpisode> episodes;
    public Paging<SimplifiedPlaylist> playlists;
    public Paging<SimplifiedShow> shows;
    public Paging<Track> tracks;
}
