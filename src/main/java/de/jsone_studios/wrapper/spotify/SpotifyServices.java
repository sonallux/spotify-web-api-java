package de.jsone_studios.wrapper.spotify;

import de.jsone_studios.wrapper.spotify.models.ErrorDetails;
import de.jsone_studios.wrapper.spotify.models.ErrorResponse;
import de.jsone_studios.wrapper.spotify.services.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;

public interface SpotifyServices {

    default <T> T callApiAndReturnBody(Call<T> call) throws SpotifyApiException {
        return getBody(callApi(call));
    }

    default <T> retrofit2.Response<T> callApi(Call<T> call) throws SpotifyApiException {
        try {
            return call.execute();
        }
        catch (IOException e) {
            throw new SpotifyApiException("Failed to make api call", e);
        }
    }

    default <T> T getBody(retrofit2.Response<T> response) throws SpotifyApiException {
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }

        throw new SpotifyApiException("Api call failed", getErrorBody(response));
    }

    default ErrorDetails getErrorBody(retrofit2.Response<?> response) throws SpotifyApiException {
        if (response.errorBody() == null) {
            throw new SpotifyApiException("Failed to get error body", getErrorDetailsFromResponse(response));
        }
        try {
            Converter<ResponseBody, ErrorResponse> converter = getRetrofit().responseBodyConverter(ErrorResponse.class, new Annotation[0]);
            ErrorResponse errorResponse = converter.convert(response.errorBody());
            if (errorResponse != null) {
                return errorResponse.error;
            }
        }
        catch (IOException ignore) {}
        throw new SpotifyApiException("Failed to parse error body", getErrorDetailsFromResponse(response));
    }

    default ErrorDetails getErrorDetailsFromResponse(retrofit2.Response<?> response) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.status = response.code();
        errorDetails.message = response.message();
        return errorDetails;
    }

    Retrofit getRetrofit();

    AlbumsSpotifyService getAlbumsService();

    ArtistsSpotifyService getArtistsService();

    BrowseSpotifyService getBrowseService();

    FollowSpotifyService getFollowService();

    LibrarySpotifyService getLibraryService();

    PersonalizationSpotifyService getPersonalizationService();

    PlaylistsSpotifyService getPlaylistsService();

    PlaylistTracksSpotifyService getPlaylistTracksService();

    SearchSpotifyService getSearchService();

    TracksSpotifyService getTracksService();

    UsersProfileSpotifyService getUsersProfileService();
}
