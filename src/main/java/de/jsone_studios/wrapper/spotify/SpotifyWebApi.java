package de.jsone_studios.wrapper.spotify;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.jsone_studios.wrapper.spotify.services.*;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SpotifyWebApi implements SpotifyServices {
    public static final String SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1/";

    private final Retrofit retrofit;

    private final AlbumsSpotifyService albumsService;
    private final ArtistsSpotifyService artistsService;
    private final BrowseSpotifyService browseService;
    private final FollowSpotifyService followService;
    private final LibrarySpotifyService libraryService;
    private final PersonalizationSpotifyService personalizationService;
    private final PlaylistsSpotifyService playlistsService;
    private final PlaylistTracksSpotifyService playlistTracksService;
    private final SearchSpotifyService searchService;
    private final TracksSpotifyService tracksService;
    private final UsersProfileSpotifyService usersProfileService;

    public SpotifyWebApi(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.albumsService = retrofit.create(AlbumsSpotifyService.class);
        this.artistsService = retrofit.create(ArtistsSpotifyService.class);
        this.browseService = retrofit.create(BrowseSpotifyService.class);
        this.followService = retrofit.create(FollowSpotifyService.class);
        this.libraryService = retrofit.create(LibrarySpotifyService.class);
        this.personalizationService = retrofit.create(PersonalizationSpotifyService.class);
        this.playlistsService = retrofit.create(PlaylistsSpotifyService.class);
        this.playlistTracksService = retrofit.create(PlaylistTracksSpotifyService.class);
        this.searchService = retrofit.create(SearchSpotifyService.class);
        this.tracksService = retrofit.create(TracksSpotifyService.class);
        this.usersProfileService = retrofit.create(UsersProfileSpotifyService.class);
    }

    public SpotifyWebApi(HttpUrl baseUrl) {
        this(createDefaultRetrofit(baseUrl));
    }

    public SpotifyWebApi(String baseUrl) {
        this(HttpUrl.get(baseUrl));
    }

    public SpotifyWebApi() {
        this(SPOTIFY_WEB_API_ENDPOINT);
    }

    private static Retrofit createDefaultRetrofit(HttpUrl baseUrl) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
    }

    @Override
    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public AlbumsSpotifyService getAlbumsService() {
        return albumsService;
    }

    @Override
    public ArtistsSpotifyService getArtistsService() {
        return artistsService;
    }

    @Override
    public BrowseSpotifyService getBrowseService() {
        return browseService;
    }

    @Override
    public FollowSpotifyService getFollowService() {
        return followService;
    }

    @Override
    public LibrarySpotifyService getLibraryService() {
        return libraryService;
    }

    @Override
    public PersonalizationSpotifyService getPersonalizationService() {
        return personalizationService;
    }

    @Override
    public PlaylistsSpotifyService getPlaylistsService() {
        return playlistsService;
    }

    @Override
    public PlaylistTracksSpotifyService getPlaylistTracksService() {
        return playlistTracksService;
    }

    @Override
    public SearchSpotifyService getSearchService() {
        return searchService;
    }

    @Override
    public TracksSpotifyService getTracksService() {
        return tracksService;
    }

    @Override
    public UsersProfileSpotifyService getUsersProfileService() {
        return usersProfileService;
    }
}
