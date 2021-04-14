# spotify-web-api-java

[![Build](https://github.com/sonallux/spotify-web-api-java/workflows/Build/badge.svg)](https://github.com/sonallux/spotify-web-api-java/actions?query=workflow%3ABuild)
[![Maven Central](https://img.shields.io/maven-central/v/de.sonallux.spotify/spotify-web-api-java)](https://search.maven.org/search?q=g:%22de.sonallux.spotify%22%20AND%20a:%22spotify-web-api-java%22)
[![GitHub](https://img.shields.io/github/license/sonallux/spotify-web-api-java)](https://github.com/sonallux/spotify-web-api-java/blob/master/LICENSE)

A Java wrapper for Spotify's Web API.

This is the 2.x.x version of the `spotify-web-api-java` library. The 1.x.x version can be found on the [master branch](https://github.com/sonallux/spotify-web-api-java/tree/master)

## Installation
This library is available on [Maven Central](https://search.maven.org/search?q=g:%22de.sonallux.spotify%22%20AND%20a:%22spotify-web-api-java%22) and requires at least Java 11:

### With maven
```xml
<dependency>
  <groupId>de.sonallux.spotify</groupId>
  <artifactId>spotify-web-api-java</artifactId>
  <version>2.0.0</version>
</dependency>
```

### With gradle
```groovy
compile 'de.sonallux.spotify:spotify-web-api-java:2.0.0'
```

## General usage
```java
var authProvider = new SimpleApiAuthorizationProvider("<your access token>");
var spotifyApi = SpotifyWebApi.builder().authorization(authProvider).build();

var artist = spotifyApi.getArtistsApi().getArtist("<artist id>").build().execute();
System.out.println(artist.getName());
```

## Authorization
Spotify's web API supports different [authorization flows](https://developer.spotify.com/documentation/general/guides/authorization-guide). All flows require that your application is registered on the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard). You can find more details on how to register your app [here](https://developer.spotify.com/documentation/general/guides/app-settings/#register-your-app). After successful registration you can use one of the following authorization flows with the `spotify-web-api-java`:

### [Authorization code flow](https://developer.spotify.com/documentation/general/guides/authorization-guide/#authorization-code-flow)
Code example: [AuthorizationCodeExample.java](spotify-web-api-java/src/test/java/examples/AuthorizationCodeExample.java)
### [Authorization code flow with proof key for code exchange (PKCE)](https://developer.spotify.com/documentation/general/guides/authorization-guide/#authorization-code-flow-with-proof-key-for-code-exchange-pkce)
Code example: [AuthorizationCodePKCEExample.java](spotify-web-api-java/src/test/java/examples/AuthorizationCodePKCEExample.java)
### [Implicit grant](https://developer.spotify.com/documentation/general/guides/authorization-guide/#implicit-grant-flow)
Code example: [ImplicitGrantExample.java](spotify-web-api-java/src/test/java/examples/ImplicitGrantExample.java)
### [Client credentials flow](https://developer.spotify.com/documentation/general/guides/authorization-guide/#client-credentials-flow)
Code example: [ClientCredentialsExample.java](spotify-web-api-java/src/test/java/examples/ClientCredentialsExample.java)

## How to release a new version
1. Update the version number with `./mvnw versions:set -DnewVersion="<version>" -DgenerateBackupPoms=false`
2. Update CHANGELOG.md
3. Commit and push changes to GitHub
4. Wait till CI is green
5. Tag and push the commit created in step 1. A GitHub actions workflow will automatically deploy the artifacts to Maven Central.
