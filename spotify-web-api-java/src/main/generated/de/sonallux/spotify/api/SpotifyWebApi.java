package de.sonallux.spotify.api;

import de.sonallux.spotify.api.apis.*;
import de.sonallux.spotify.api.http.ApiClient;
import lombok.Getter;
import okhttp3.HttpUrl;
import org.jspecify.annotations.NullMarked;

@Getter
@NullMarked
public class SpotifyWebApi  {
    public static final HttpUrl SPOTIFY_WEB_API_ENDPOINT = HttpUrl.get("https://api.spotify.com/v1");

    private final AlbumsApi albumsApi;
    private final ArtistsApi artistsApi;
    private final AudiobooksApi audiobooksApi;
    private final CategoriesApi categoriesApi;
    private final ChaptersApi chaptersApi;
    private final EpisodesApi episodesApi;
    private final GenresApi genresApi;
    private final MarketsApi marketsApi;
    private final PlayerApi playerApi;
    private final PlaylistsApi playlistsApi;
    private final SearchApi searchApi;
    private final ShowsApi showsApi;
    private final TracksApi tracksApi;
    private final UsersApi usersApi;

    SpotifyWebApi(ApiClient apiClient) {
        this.albumsApi = new AlbumsApi(apiClient);
        this.artistsApi = new ArtistsApi(apiClient);
        this.audiobooksApi = new AudiobooksApi(apiClient);
        this.categoriesApi = new CategoriesApi(apiClient);
        this.chaptersApi = new ChaptersApi(apiClient);
        this.episodesApi = new EpisodesApi(apiClient);
        this.genresApi = new GenresApi(apiClient);
        this.marketsApi = new MarketsApi(apiClient);
        this.playerApi = new PlayerApi(apiClient);
        this.playlistsApi = new PlaylistsApi(apiClient);
        this.searchApi = new SearchApi(apiClient);
        this.showsApi = new ShowsApi(apiClient);
        this.tracksApi = new TracksApi(apiClient);
        this.usersApi = new UsersApi(apiClient);
    }

    public static SpotifyWebApiBuilder builder() {
        return new SpotifyWebApiBuilder();
    }
}
