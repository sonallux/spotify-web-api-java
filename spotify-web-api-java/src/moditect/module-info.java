module de.sonallux.spotify.api {
    requires com.fasterxml.jackson.datatype.jsr310;
    requires okio;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires okhttp3;

    exports de.sonallux.spotify.api;
    exports de.sonallux.spotify.api.apis;
    exports de.sonallux.spotify.api.apis.albums;
    exports de.sonallux.spotify.api.apis.artists;
    exports de.sonallux.spotify.api.apis.browse;
    exports de.sonallux.spotify.api.apis.episodes;
    exports de.sonallux.spotify.api.apis.follow;
    exports de.sonallux.spotify.api.apis.library;
    exports de.sonallux.spotify.api.apis.markets;
    exports de.sonallux.spotify.api.apis.personalization;
    exports de.sonallux.spotify.api.apis.player;
    exports de.sonallux.spotify.api.apis.playlists;
    exports de.sonallux.spotify.api.apis.search;
    exports de.sonallux.spotify.api.apis.shows;
    exports de.sonallux.spotify.api.apis.tracks;
    exports de.sonallux.spotify.api.apis.usersprofile;
    exports de.sonallux.spotify.api.authorization;
    exports de.sonallux.spotify.api.authorization.authorization_code;
    exports de.sonallux.spotify.api.authorization.client_credentials;
    exports de.sonallux.spotify.api.http;
    exports de.sonallux.spotify.api.models;
    exports de.sonallux.spotify.api.util;
}
