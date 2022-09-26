package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.player.*;
import lombok.RequiredArgsConstructor;

/**
 * Player
 */
@RequiredArgsConstructor
public class PlayerApi {
    private final ApiClient apiClient;

    /**
     * <h4>Add Item to Playback Queue</h4>
     * <p>Add an item to the end of the user's current playback queue.</p>
     * @param uri <p>The uri of the item to add to the queue. Must be a track or an episode uri.</p>
     * @return a {@link AddToQueueRequest} object to build and execute the request
     */
    public AddToQueueRequest addToQueue(String uri) {
        return new AddToQueueRequest(apiClient, uri);
    }

    /**
     * <h4>Get Playback State</h4>
     * <p>Get information about the user’s current playback state, including track or episode, progress, and active device.</p>
     * @return a {@link GetInformationAboutUsersCurrentPlaybackRequest} object to build and execute the request
     */
    public GetInformationAboutUsersCurrentPlaybackRequest getInformationAboutUsersCurrentPlayback() {
        return new GetInformationAboutUsersCurrentPlaybackRequest(apiClient);
    }

    /**
     * <h4>Get the User's Queue</h4>
     * <p>Get the list of objects that make up the user's queue.</p>
     * @return a {@link GetQueueRequest} object to build and execute the request
     */
    public GetQueueRequest getQueue() {
        return new GetQueueRequest(apiClient);
    }

    /**
     * <h4>Get Recently Played Tracks</h4>
     * <p>Get tracks from the current user's recently played tracks. <em><strong>Note</strong>: Currently doesn't support podcast episodes.</em></p>
     * @return a {@link GetRecentlyPlayedRequest} object to build and execute the request
     */
    public GetRecentlyPlayedRequest getRecentlyPlayed() {
        return new GetRecentlyPlayedRequest(apiClient);
    }

    /**
     * <h4>Get Available Devices</h4>
     * <p>Get information about a user’s available devices.</p>
     * @return a {@link GetUsersAvailableDevicesRequest} object to build and execute the request
     */
    public GetUsersAvailableDevicesRequest getUsersAvailableDevices() {
        return new GetUsersAvailableDevicesRequest(apiClient);
    }

    /**
     * <h4>Get Currently Playing Track</h4>
     * <p>Get the object currently being played on the user's Spotify account.</p>
     * @return a {@link GetUsersCurrentlyPlayingTrackRequest} object to build and execute the request
     */
    public GetUsersCurrentlyPlayingTrackRequest getUsersCurrentlyPlayingTrack() {
        return new GetUsersCurrentlyPlayingTrackRequest(apiClient);
    }

    /**
     * <h4>Pause Playback</h4>
     * <p>Pause playback on the user's account.</p>
     * @return a {@link PauseUsersPlaybackRequest} object to build and execute the request
     */
    public PauseUsersPlaybackRequest pauseUsersPlayback() {
        return new PauseUsersPlaybackRequest(apiClient);
    }

    /**
     * <h4>Seek To Position</h4>
     * <p>Seeks to the given position in the user’s currently playing track.</p>
     * @param positionMs <p>The position in milliseconds to seek to. Must be a positive number. Passing in a position that is greater than the length of the track will cause the player to start playing the next song.</p>
     * @return a {@link SeekToPositionInCurrentlyPlayingTrackRequest} object to build and execute the request
     */
    public SeekToPositionInCurrentlyPlayingTrackRequest seekToPositionInCurrentlyPlayingTrack(int positionMs) {
        return new SeekToPositionInCurrentlyPlayingTrackRequest(apiClient, positionMs);
    }

    /**
     * <h4>Set Repeat Mode</h4>
     * <p>Set the repeat mode for the user's playback. Options are repeat-track, repeat-context, and off.</p>
     * @param state <p><strong>track</strong>, <strong>context</strong> or <strong>off</strong>.<br><strong>track</strong> will repeat the current track.<br><strong>context</strong> will repeat the current context.<br><strong>off</strong> will turn repeat off.</p>
     * @return a {@link SetRepeatModeOnUsersPlaybackRequest} object to build and execute the request
     */
    public SetRepeatModeOnUsersPlaybackRequest setRepeatModeOnUsersPlayback(String state) {
        return new SetRepeatModeOnUsersPlaybackRequest(apiClient, state);
    }

    /**
     * <h4>Set Playback Volume</h4>
     * <p>Set the volume for the user’s current playback device.</p>
     * @param volumePercent <p>The volume to set. Must be a value from 0 to 100 inclusive.</p>
     * @return a {@link SetVolumeForUsersPlaybackRequest} object to build and execute the request
     */
    public SetVolumeForUsersPlaybackRequest setVolumeForUsersPlayback(int volumePercent) {
        return new SetVolumeForUsersPlaybackRequest(apiClient, volumePercent);
    }

    /**
     * <h4>Skip To Next</h4>
     * <p>Skips to next track in the user’s queue.</p>
     * @return a {@link SkipUsersPlaybackToNextTrackRequest} object to build and execute the request
     */
    public SkipUsersPlaybackToNextTrackRequest skipUsersPlaybackToNextTrack() {
        return new SkipUsersPlaybackToNextTrackRequest(apiClient);
    }

    /**
     * <h4>Skip To Previous</h4>
     * <p>Skips to previous track in the user’s queue.</p>
     * @return a {@link SkipUsersPlaybackToPreviousTrackRequest} object to build and execute the request
     */
    public SkipUsersPlaybackToPreviousTrackRequest skipUsersPlaybackToPreviousTrack() {
        return new SkipUsersPlaybackToPreviousTrackRequest(apiClient);
    }

    /**
     * <h4>Start/Resume Playback</h4>
     * <p>Start a new context or resume current playback on the user's active device.</p>
     * @return a {@link StartUsersPlaybackRequest} object to build and execute the request
     */
    public StartUsersPlaybackRequest startUsersPlayback() {
        return new StartUsersPlaybackRequest(apiClient);
    }

    /**
     * <h4>Toggle Playback Shuffle</h4>
     * <p>Toggle shuffle on or off for user’s playback.</p>
     * @param state <p><strong>true</strong> : Shuffle user's playback.<br><strong>false</strong> : Do not shuffle user's playback.</p>
     * @return a {@link ToggleShuffleForUsersPlaybackRequest} object to build and execute the request
     */
    public ToggleShuffleForUsersPlaybackRequest toggleShuffleForUsersPlayback(boolean state) {
        return new ToggleShuffleForUsersPlaybackRequest(apiClient, state);
    }

    /**
     * <h4>Transfer Playback</h4>
     * <p>Transfer playback to a new device and determine if it should start playing.</p>
     * @param deviceIds <p>A JSON array containing the ID of the device on which playback should be started/transferred.<br>For example:<code>{device_ids:[&quot;74ASZWbe4lXaubB36ztrGX&quot;]}</code><br><em><strong>Note</strong>: Although an array is accepted, only a single device_id is currently supported. Supplying more than one will return <code>400 Bad Request</code></em></p>
     * @return a {@link TransferUsersPlaybackRequest} object to build and execute the request
     */
    public TransferUsersPlaybackRequest transferUsersPlayback(java.util.List<String> deviceIds) {
        return new TransferUsersPlaybackRequest(apiClient, deviceIds);
    }
}
