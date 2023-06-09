package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.tracks.*;
import lombok.RequiredArgsConstructor;

/**
 * Tracks
 */
@RequiredArgsConstructor
public class TracksApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Tracks</h4>
     * <p>Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedTracksRequest} object to build and execute the request
     */
    public CheckUsersSavedTracksRequest checkUsersSavedTracks(String ids) {
        return new CheckUsersSavedTracksRequest(apiClient, ids);
    }

    /**
     * <h4>Get Track's Audio Analysis</h4>
     * <p>Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the track.</p>
     * @return a {@link GetAudioAnalysisRequest} object to build and execute the request
     */
    public GetAudioAnalysisRequest getAudioAnalysis(String id) {
        return new GetAudioAnalysisRequest(apiClient, id);
    }

    /**
     * <h4>Get Track's Audio Features</h4>
     * <p>Get audio feature information for a single track identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> for the track.</p>
     * @return a {@link GetAudioFeaturesRequest} object to build and execute the request
     */
    public GetAudioFeaturesRequest getAudioFeatures(String id) {
        return new GetAudioFeaturesRequest(apiClient, id);
    }

    /**
     * <h4>Get Recommendations</h4>
     * <p>Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks. If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.</p><p>For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.</p>
     * @return a {@link GetRecommendationsRequest} object to build and execute the request
     */
    public GetRecommendationsRequest getRecommendations() {
        return new GetRecommendationsRequest(apiClient);
    }

    /**
     * <h4>Get Tracks' Audio Features</h4>
     * <p>Get audio features for multiple tracks based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>for the tracks. Maximum: 100 IDs.</p>
     * @return a {@link GetSeveralAudioFeaturesRequest} object to build and execute the request
     */
    public GetSeveralAudioFeaturesRequest getSeveralAudioFeatures(String ids) {
        return new GetSeveralAudioFeaturesRequest(apiClient, ids);
    }

    /**
     * <h4>Get Several Tracks</h4>
     * <p>Get Spotify catalog information for multiple tracks based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetSeveralTracksRequest} object to build and execute the request
     */
    public GetSeveralTracksRequest getSeveralTracks(String ids) {
        return new GetSeveralTracksRequest(apiClient, ids);
    }

    /**
     * <h4>Get Track</h4>
     * <p>Get Spotify catalog information for a single track identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the track.</p>
     * @return a {@link GetTrackRequest} object to build and execute the request
     */
    public GetTrackRequest getTrack(String id) {
        return new GetTrackRequest(apiClient, id);
    }

    /**
     * <h4>Get User's Saved Tracks</h4>
     * <p>Get a list of the songs saved in the current Spotify user's 'Your Music' library.</p>
     * @return a {@link GetUsersSavedTracksRequest} object to build and execute the request
     */
    public GetUsersSavedTracksRequest getUsersSavedTracks() {
        return new GetUsersSavedTracksRequest(apiClient);
    }

    /**
     * <h4>Remove User's Saved Tracks</h4>
     * <p>Remove one or more tracks from the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveTracksUserRequest} object to build and execute the request
     */
    public RemoveTracksUserRequest removeTracksUser(java.util.List<String> ids) {
        return new RemoveTracksUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Tracks for Current User</h4>
     * <p>Save one or more tracks to the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveTracksUserRequest} object to build and execute the request
     */
    public SaveTracksUserRequest saveTracksUser(java.util.List<String> ids) {
        return new SaveTracksUserRequest(apiClient, ids);
    }
}
