package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.audiobooks.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Audiobooks
 */
@NullMarked
@RequiredArgsConstructor
public class AudiobooksApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Audiobooks</h4>
     * <p>Check if one or more audiobooks are already saved in the current Spotify user's library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedAudiobooksRequest} object to build and execute the request
     */
    public CheckUsersSavedAudiobooksRequest checkUsersSavedAudiobooks(String ids) {
        return new CheckUsersSavedAudiobooksRequest(apiClient, ids);
    }

    /**
     * <h4>Get an Audiobook</h4>
     * <p>Get Spotify catalog information for a single audiobook. Audiobooks are only available within the US, UK, Canada, Ireland, New Zealand and Australia markets.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the audiobook.</p>
     * @return a {@link GetAudiobookRequest} object to build and execute the request
     */
    public GetAudiobookRequest getAudiobook(String id) {
        return new GetAudiobookRequest(apiClient, id);
    }

    /**
     * <h4>Get Audiobook Chapters</h4>
     * <p>Get Spotify catalog information about an audiobook's chapters. Audiobooks are only available within the US, UK, Canada, Ireland, New Zealand and Australia markets.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the audiobook.</p>
     * @return a {@link GetAudiobookChaptersRequest} object to build and execute the request
     */
    public GetAudiobookChaptersRequest getAudiobookChapters(String id) {
        return new GetAudiobookChaptersRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Audiobooks</h4>
     * <p>Get Spotify catalog information for several audiobooks identified by their Spotify IDs. Audiobooks are only available within the US, UK, Canada, Ireland, New Zealand and Australia markets.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleAudiobooksRequest} object to build and execute the request
     */
    public GetMultipleAudiobooksRequest getMultipleAudiobooks(String ids) {
        return new GetMultipleAudiobooksRequest(apiClient, ids);
    }

    /**
     * <h4>Get User's Saved Audiobooks</h4>
     * <p>Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.</p>
     * @return a {@link GetUsersSavedAudiobooksRequest} object to build and execute the request
     */
    public GetUsersSavedAudiobooksRequest getUsersSavedAudiobooks() {
        return new GetUsersSavedAudiobooksRequest(apiClient);
    }

    /**
     * <h4>Remove User's Saved Audiobooks</h4>
     * <p>Remove one or more audiobooks from the Spotify user's library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     * @return a {@link RemoveAudiobooksUserRequest} object to build and execute the request
     */
    public RemoveAudiobooksUserRequest removeAudiobooksUser(String ids) {
        return new RemoveAudiobooksUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Audiobooks for Current User</h4>
     * <p>Save one or more audiobooks to the current Spotify user's library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     * @return a {@link SaveAudiobooksUserRequest} object to build and execute the request
     */
    public SaveAudiobooksUserRequest saveAudiobooksUser(String ids) {
        return new SaveAudiobooksUserRequest(apiClient, ids);
    }
}
