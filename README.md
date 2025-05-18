# spotify-web-api-java

[![Build](https://github.com/sonallux/spotify-web-api-java/workflows/Build/badge.svg)](https://github.com/sonallux/spotify-web-api-java/actions?query=workflow%3ABuild)
[![Maven Central](https://img.shields.io/maven-central/v/de.sonallux.spotify/spotify-web-api-java)](https://central.sonatype.com/artifact/de.sonallux.spotify/spotify-web-api-java)
[![GitHub](https://img.shields.io/github/license/sonallux/spotify-web-api-java)](https://github.com/sonallux/spotify-web-api-java/blob/main/LICENSE)

A Java wrapper for Spotify's Web API.

## Installation
This library is available on [Maven Central](https://central.sonatype.com/artifact/de.sonallux.spotify/spotify-web-api-java) and requires at least Java 17.

### With maven
```xml
<dependency>
  <groupId>de.sonallux.spotify</groupId>
  <artifactId>spotify-web-api-java</artifactId>
  <version>4.3.2</version>
</dependency>
```

### With gradle
```groovy
compile 'de.sonallux.spotify:spotify-web-api-java:4.3.2'
```

## General usage
```java
var authProvider = new SimpleApiAuthorizationProvider("<your access token>");
var spotifyApi = SpotifyWebApi.builder().authorization(authProvider).build();

var artist = spotifyApi.getArtistsApi().getArtist("<artist id>").build().execute();
System.out.println(artist.getName());
```

## Authorization
Spotify's web API supports different [authorization flows](https://developer.spotify.com/documentation/web-api/concepts/authorization). All flows require that your application is registered on the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard). You can find more details on how to register your app [here](https://developer.spotify.com/documentation/web-api/concepts/apps). After successful registration you can use one of the following authorization flows with the `spotify-web-api-java`:

### [Authorization code flow](https://developer.spotify.com/documentation/web-api/tutorials/code-flow)
Code example: [AuthorizationCodeExample.java](spotify-web-api-java/src/test/java/examples/AuthorizationCodeExample.java)
### [Authorization code flow with proof key for code exchange (PKCE)](https://developer.spotify.com/documentation/web-api/tutorials/code-pkce-flow)
Code example: [AuthorizationCodePKCEExample.java](spotify-web-api-java/src/test/java/examples/AuthorizationCodePKCEExample.java)
### [Implicit grant](https://developer.spotify.com/documentation/web-api/tutorials/implicit-flow)
Code example: [ImplicitGrantExample.java](spotify-web-api-java/src/test/java/examples/ImplicitGrantExample.java)
### [Client credentials flow](https://developer.spotify.com/documentation/web-api/tutorials/client-credentials-flow)
Code example: [ClientCredentialsExample.java](spotify-web-api-java/src/test/java/examples/ClientCredentialsExample.java)

## How to release a new version
1. Update the version number with `./mvnw versions:set -DnewVersion="<version>" -DgenerateBackupPoms=false`
2. Update version in `CHANGELOG.md` and `README.md`
3. Commit and push changes to GitHub
4. Wait till CI is green
5. Tag the commit created in step 3 and push it. A GitHub actions workflow will automatically deploy the artifacts to Maven Central.
6. Create a release on GitHub mentioning the changes from `CHANGELOG.md`
