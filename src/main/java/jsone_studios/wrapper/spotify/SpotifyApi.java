package jsone_studios.wrapper.spotify;

import jsone_studios.wrapper.spotify.services.AlbumsSpotifyService;
import jsone_studios.wrapper.spotify.services.ArtistsSpotifyService;
import jsone_studios.wrapper.spotify.services.TracksSpotifyService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SpotifyApi
{
    public static final String SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1/";

    private final ArtistsSpotifyService artistsService;
    private final AlbumsSpotifyService albumsService;
    private final TracksSpotifyService tracksService;

    private String accessToken = null;

    public SpotifyApi()
    {
        Retrofit retrofit = createRetrofit();
        this.artistsService = retrofit.create(ArtistsSpotifyService.class);
        this.albumsService = retrofit.create(AlbumsSpotifyService.class);
        this.tracksService = retrofit.create(TracksSpotifyService.class);
    }

    private Retrofit createRetrofit()
    {
        return new Retrofit.Builder()
            .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(new OkHttpClient.Builder().addInterceptor(chain -> {
                Request request = chain.request();
                if (accessToken != null) {

                    request = request.newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                }
                return chain.proceed(request);
            }).build())
            .build();
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public ArtistsSpotifyService getArtistsService()
    {
        return artistsService;
    }

    public AlbumsSpotifyService getAlbumsService()
    {
        return albumsService;
    }

    public TracksSpotifyService getTracksService()
    {
        return tracksService;
    }
}
