# spotify-web-api-java

[![Build Status](https://travis-ci.com/jsone-studios/spotify-web-api-java.svg?branch=master)](https://travis-ci.com/jsone-studios/spotify-web-api-java)
[![Maven Central](https://img.shields.io/maven-central/v/de.jsone-studios/spotify-web-api-java)](https://search.maven.org/search?q=g:%22de.jsone-studios%22%20AND%20a:%22spotify-web-api-java%22)
[![GitHub](https://img.shields.io/github/license/jsone-studios/spotify-web-api-java)](https://github.com/jsone-studios/spotify-web-api-java/blob/master/LICENSE)
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=jsone-studios/spotify-web-api-java)](https://dependabot.com)

A Java wrapper for Spotify's Web API using [Retrofit](http://square.github.io/retrofit/)

## Example: Get the number of tracks of a playlist
````java
AuthenticationProvider authProvider = ...;
SpotifyApi api = new AuthenticatedSpotifyApi(authProvider);
try {
    Playlist playlist = api.callApiAndReturnBody(
        api.getPlaylistsService().getPlaylist("spotify:playlist:37i9dQZEVXbMDoHDwVN2tF"));
    System.out.printf("Playlist %s has %s tracks\n", playlist.name, playlist.tracks.total);
}
catch (SpotifyApiException e) {
    System.err.println(e.getMessage());
}
````

## Authentication and Authorization
All calls to the Spotify Web Api need authorization. Therefore it is mandatory to provide the required authentication 
and authorization data. Spotify provides multiple [authorization flows](https://developer.spotify.com/documentation/general/guides/authorization-guide/).
This library provides two option for authentication and authorization:
- The `AuthenticatedSpotifyApi` provides support for the authorization code flow. Therefore only the 
`AuthenticationProvider` interface must be implemented.
- The `SpotifyWebApi` provides no built in authentication or authorization. But a `OkHttpClient` can be provided 
to customize the authentication and authorization. For example a custom `Interceptor`
can be used to add the access token to every request.

## Releases
`spotify-web-api-java` is available on Maven Central.

### Maven
```
<dependency>
    <groupId>de.jsone-studios</groupId>
    <artifactId>spotify-web-api-java</artifactId>
    <version>1.3.2</version>
</dependency>
```

### Gradle
```
dependencies {
    compile 'de.jsone-studios:spotify-web-api-java:1.3.2'
}    
```

## Deploy a new release to Maven Central
- Update version number
- Commit changes
- Create signed git tag with `git tag -s <tag>`
- Run `mvn clean deploy -Pdeploy`
- Update version number to next SNAPSHOT version