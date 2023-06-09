package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Recommendations request</h2>
 *
 * <h3>Response</h3>
 * <p>A set of recommendations</p>
 */
public class GetRecommendationsRequest {
    private static final TypeReference<Recommendations> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Recommendations request
     * @param apiClient <p>The API client</p>
     */
    public GetRecommendationsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/recommendations")
        ;
    }

    /**
     * @param limit <p>The target size of the list of recommended tracks. For seeds with unusually small pools or when highly restrictive filtering is applied, it may be impossible to generate the requested number of recommended tracks. Debugging information for such cases is available in the response. Default: 20. Minimum: 1. Maximum: 100.</p>
     * @return this request
     */
    public GetRecommendationsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br/>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br/><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br/>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetRecommendationsRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * @param seedArtists <p>A comma separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for seed artists.  Up to 5 seed values may be provided in any combination of <code>seed_artists</code>, <code>seed_tracks</code> and <code>seed_genres</code>.</p>
     * @return this request
     */
    public GetRecommendationsRequest seedArtists(String seedArtists) {
        this.request.addQueryParameter("seed_artists", String.valueOf(seedArtists));
        return this;
    }

    /**
     * @param seedGenres <p>A comma separated list of any genres in the set of <a href="#available-genre-seeds">available genre seeds</a>.  Up to 5 seed values may be provided in any combination of <code>seed_artists</code>, <code>seed_tracks</code> and <code>seed_genres</code>.</p>
     * @return this request
     */
    public GetRecommendationsRequest seedGenres(String seedGenres) {
        this.request.addQueryParameter("seed_genres", String.valueOf(seedGenres));
        return this;
    }

    /**
     * @param seedTracks <p>A comma separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for a seed track.  Up to 5 seed values may be provided in any combination of <code>seed_artists</code>, <code>seed_tracks</code> and <code>seed_genres</code>.</p>
     * @return this request
     */
    public GetRecommendationsRequest seedTracks(String seedTracks) {
        this.request.addQueryParameter("seed_tracks", String.valueOf(seedTracks));
        return this;
    }

    /**
     * @param minAcousticness <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minAcousticness(float minAcousticness) {
        this.request.addQueryParameter("min_acousticness", String.valueOf(minAcousticness));
        return this;
    }

    /**
     * @param maxAcousticness <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxAcousticness(float maxAcousticness) {
        this.request.addQueryParameter("max_acousticness", String.valueOf(maxAcousticness));
        return this;
    }

    /**
     * @param targetAcousticness <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetAcousticness(float targetAcousticness) {
        this.request.addQueryParameter("target_acousticness", String.valueOf(targetAcousticness));
        return this;
    }

    /**
     * @param minDanceability <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minDanceability(float minDanceability) {
        this.request.addQueryParameter("min_danceability", String.valueOf(minDanceability));
        return this;
    }

    /**
     * @param maxDanceability <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxDanceability(float maxDanceability) {
        this.request.addQueryParameter("max_danceability", String.valueOf(maxDanceability));
        return this;
    }

    /**
     * @param targetDanceability <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetDanceability(float targetDanceability) {
        this.request.addQueryParameter("target_danceability", String.valueOf(targetDanceability));
        return this;
    }

    /**
     * @param minDurationMs <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minDurationMs(int minDurationMs) {
        this.request.addQueryParameter("min_duration_ms", String.valueOf(minDurationMs));
        return this;
    }

    /**
     * @param maxDurationMs <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxDurationMs(int maxDurationMs) {
        this.request.addQueryParameter("max_duration_ms", String.valueOf(maxDurationMs));
        return this;
    }

    /**
     * @param targetDurationMs <p>Target duration of the track (ms)</p>
     * @return this request
     */
    public GetRecommendationsRequest targetDurationMs(int targetDurationMs) {
        this.request.addQueryParameter("target_duration_ms", String.valueOf(targetDurationMs));
        return this;
    }

    /**
     * @param minEnergy <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minEnergy(float minEnergy) {
        this.request.addQueryParameter("min_energy", String.valueOf(minEnergy));
        return this;
    }

    /**
     * @param maxEnergy <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxEnergy(float maxEnergy) {
        this.request.addQueryParameter("max_energy", String.valueOf(maxEnergy));
        return this;
    }

    /**
     * @param targetEnergy <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetEnergy(float targetEnergy) {
        this.request.addQueryParameter("target_energy", String.valueOf(targetEnergy));
        return this;
    }

    /**
     * @param minInstrumentalness <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minInstrumentalness(float minInstrumentalness) {
        this.request.addQueryParameter("min_instrumentalness", String.valueOf(minInstrumentalness));
        return this;
    }

    /**
     * @param maxInstrumentalness <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxInstrumentalness(float maxInstrumentalness) {
        this.request.addQueryParameter("max_instrumentalness", String.valueOf(maxInstrumentalness));
        return this;
    }

    /**
     * @param targetInstrumentalness <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetInstrumentalness(float targetInstrumentalness) {
        this.request.addQueryParameter("target_instrumentalness", String.valueOf(targetInstrumentalness));
        return this;
    }

    /**
     * @param minKey <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minKey(int minKey) {
        this.request.addQueryParameter("min_key", String.valueOf(minKey));
        return this;
    }

    /**
     * @param maxKey <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxKey(int maxKey) {
        this.request.addQueryParameter("max_key", String.valueOf(maxKey));
        return this;
    }

    /**
     * @param targetKey <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetKey(int targetKey) {
        this.request.addQueryParameter("target_key", String.valueOf(targetKey));
        return this;
    }

    /**
     * @param minLiveness <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minLiveness(float minLiveness) {
        this.request.addQueryParameter("min_liveness", String.valueOf(minLiveness));
        return this;
    }

    /**
     * @param maxLiveness <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxLiveness(float maxLiveness) {
        this.request.addQueryParameter("max_liveness", String.valueOf(maxLiveness));
        return this;
    }

    /**
     * @param targetLiveness <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetLiveness(float targetLiveness) {
        this.request.addQueryParameter("target_liveness", String.valueOf(targetLiveness));
        return this;
    }

    /**
     * @param minLoudness <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minLoudness(float minLoudness) {
        this.request.addQueryParameter("min_loudness", String.valueOf(minLoudness));
        return this;
    }

    /**
     * @param maxLoudness <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxLoudness(float maxLoudness) {
        this.request.addQueryParameter("max_loudness", String.valueOf(maxLoudness));
        return this;
    }

    /**
     * @param targetLoudness <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetLoudness(float targetLoudness) {
        this.request.addQueryParameter("target_loudness", String.valueOf(targetLoudness));
        return this;
    }

    /**
     * @param minMode <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minMode(int minMode) {
        this.request.addQueryParameter("min_mode", String.valueOf(minMode));
        return this;
    }

    /**
     * @param maxMode <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxMode(int maxMode) {
        this.request.addQueryParameter("max_mode", String.valueOf(maxMode));
        return this;
    }

    /**
     * @param targetMode <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetMode(int targetMode) {
        this.request.addQueryParameter("target_mode", String.valueOf(targetMode));
        return this;
    }

    /**
     * @param minPopularity <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minPopularity(int minPopularity) {
        this.request.addQueryParameter("min_popularity", String.valueOf(minPopularity));
        return this;
    }

    /**
     * @param maxPopularity <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxPopularity(int maxPopularity) {
        this.request.addQueryParameter("max_popularity", String.valueOf(maxPopularity));
        return this;
    }

    /**
     * @param targetPopularity <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetPopularity(int targetPopularity) {
        this.request.addQueryParameter("target_popularity", String.valueOf(targetPopularity));
        return this;
    }

    /**
     * @param minSpeechiness <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minSpeechiness(float minSpeechiness) {
        this.request.addQueryParameter("min_speechiness", String.valueOf(minSpeechiness));
        return this;
    }

    /**
     * @param maxSpeechiness <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxSpeechiness(float maxSpeechiness) {
        this.request.addQueryParameter("max_speechiness", String.valueOf(maxSpeechiness));
        return this;
    }

    /**
     * @param targetSpeechiness <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetSpeechiness(float targetSpeechiness) {
        this.request.addQueryParameter("target_speechiness", String.valueOf(targetSpeechiness));
        return this;
    }

    /**
     * @param minTempo <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minTempo(float minTempo) {
        this.request.addQueryParameter("min_tempo", String.valueOf(minTempo));
        return this;
    }

    /**
     * @param maxTempo <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxTempo(float maxTempo) {
        this.request.addQueryParameter("max_tempo", String.valueOf(maxTempo));
        return this;
    }

    /**
     * @param targetTempo <p>Target tempo (BPM)</p>
     * @return this request
     */
    public GetRecommendationsRequest targetTempo(float targetTempo) {
        this.request.addQueryParameter("target_tempo", String.valueOf(targetTempo));
        return this;
    }

    /**
     * @param minTimeSignature <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minTimeSignature(int minTimeSignature) {
        this.request.addQueryParameter("min_time_signature", String.valueOf(minTimeSignature));
        return this;
    }

    /**
     * @param maxTimeSignature <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxTimeSignature(int maxTimeSignature) {
        this.request.addQueryParameter("max_time_signature", String.valueOf(maxTimeSignature));
        return this;
    }

    /**
     * @param targetTimeSignature <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetTimeSignature(int targetTimeSignature) {
        this.request.addQueryParameter("target_time_signature", String.valueOf(targetTimeSignature));
        return this;
    }

    /**
     * @param minValence <p>For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>min_tempo=140</code> would restrict results to only those tracks with a tempo of greater than 140 beats per minute.</p>
     * @return this request
     */
    public GetRecommendationsRequest minValence(float minValence) {
        this.request.addQueryParameter("min_valence", String.valueOf(minValence));
        return this;
    }

    /**
     * @param maxValence <p>For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below for the list of available options. For example, <code>max_instrumentalness=0.35</code> would filter out most tracks that are likely to be instrumental.</p>
     * @return this request
     */
    public GetRecommendationsRequest maxValence(float maxValence) {
        this.request.addQueryParameter("max_valence", String.valueOf(maxValence));
        return this;
    }

    /**
     * @param targetValence <p>For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values nearest to the target values will be preferred. For example, you might request <code>target_energy=0.6</code> and <code>target_danceability=0.8</code>. All target values will be weighed equally in ranking results.</p>
     * @return this request
     */
    public GetRecommendationsRequest targetValence(float targetValence) {
        this.request.addQueryParameter("target_valence", String.valueOf(targetValence));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Recommendations> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
