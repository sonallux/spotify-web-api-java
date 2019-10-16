package de.jsone_studios.wrapper.spotify;

import de.jsone_studios.wrapper.spotify.services.*;

public interface SpotifyServices {
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
