package de.sonallux.spotify.api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class NewReleases {
    public Paging<SimplifiedAlbum> albums;
}
