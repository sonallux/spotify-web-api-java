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
     * <h3>Get Track's Audio Analysis</h3>
     * <p>Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a>for the track.</p>
     * @return a {@link GetAudioAnalysisRequest} object to build and execute the request
     */
    public GetAudioAnalysisRequest getAudioAnalysis(String id) {
        return new GetAudioAnalysisRequest(apiClient, id);
    }

    /**
     * <h3>Get Track's Audio Features</h3>
     * <p>Get audio feature information for a single track identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> for the track.</p>
     * @return a {@link GetAudioFeaturesRequest} object to build and execute the request
     */
    public GetAudioFeaturesRequest getAudioFeatures(String id) {
        return new GetAudioFeaturesRequest(apiClient, id);
    }

    /**
     * <h3>Get Tracks' Audio Features</h3>
     * <p>Get audio features for multiple tracks based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>for the tracks. Maximum: 100 IDs.</p>
     * @return a {@link GetSeveralAudioFeaturesRequest} object to build and execute the request
     */
    public GetSeveralAudioFeaturesRequest getSeveralAudioFeatures(String ids) {
        return new GetSeveralAudioFeaturesRequest(apiClient, ids);
    }

    /**
     * <h3>Get Several Tracks</h3>
     * <p>Get Spotify catalog information for multiple tracks based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetSeveralTracksRequest} object to build and execute the request
     */
    public GetSeveralTracksRequest getSeveralTracks(String ids) {
        return new GetSeveralTracksRequest(apiClient, ids);
    }

    /**
     * <h3>Get Track</h3>
     * <p>Get Spotify catalog information for a single track identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a>for the track.</p>
     * @return a {@link GetTrackRequest} object to build and execute the request
     */
    public GetTrackRequest getTrack(String id) {
        return new GetTrackRequest(apiClient, id);
    }
}
