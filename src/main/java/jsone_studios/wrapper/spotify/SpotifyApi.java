package jsone_studios.wrapper.spotify;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsone_studios.wrapper.spotify.services.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SpotifyApi
{
    public static final String SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1/";

    private final AlbumsSpotifyService albumsService;
    private final ArtistsSpotifyService artistsService;
    private final BrowseSpotifyService browseService;
    private final FollowSpotifyService followService;
    private final LibrarySpotifyService libraryService;
    private final PlaylistsSpotifyService playlistsService;
    private final SearchSpotifyService searchService;
    private final TracksSpotifyService tracksService;

    private OkHttpClient okHttpClient;
    private ObjectMapper objectMapper;

    private String accessToken = null;

    public SpotifyApi()
    {
        this.okHttpClient = createOkHttpClient();
        this.objectMapper = createObjectMapper();

        Retrofit retrofit = createRetrofit();
        this.albumsService = retrofit.create(AlbumsSpotifyService.class);
        this.artistsService = retrofit.create(ArtistsSpotifyService.class);
        this.browseService = retrofit.create(BrowseSpotifyService.class);
        this.followService = retrofit.create(FollowSpotifyService.class);
        this.libraryService = retrofit.create(LibrarySpotifyService.class);
        this.playlistsService = retrofit.create(PlaylistsSpotifyService.class);
        this.searchService = retrofit.create(SearchSpotifyService.class);
        this.tracksService = retrofit.create(TracksSpotifyService.class);
    }

    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            if (accessToken != null) {

                request = request.newBuilder()
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .build();
            }
            return chain.proceed(request);
        }).build();
    }

    private ObjectMapper createObjectMapper() {
        return new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private Retrofit createRetrofit()
    {
        return new Retrofit.Builder()
            .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
            .addConverterFactory(JacksonConverterFactory.create(this.objectMapper))
            .client(this.okHttpClient)
            .build();
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public AlbumsSpotifyService getAlbumsService()
    {
        return albumsService;
    }

    public ArtistsSpotifyService getArtistsService()
    {
        return artistsService;
    }

    public BrowseSpotifyService getBrowseService()
    {
        return browseService;
    }

    public FollowSpotifyService getFollowService()
    {
        return followService;
    }

    public LibrarySpotifyService getLibraryService()
    {
        return libraryService;
    }

    public PlaylistsSpotifyService getPlaylistsService()
    {
        return playlistsService;
    }

    public SearchSpotifyService getSearchService()
    {
        return searchService;
    }

    public TracksSpotifyService getTracksService()
    {
        return tracksService;
    }
}
