package de.sonallux.spotify.api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Categories {
    public Paging<Category> categories;
}
