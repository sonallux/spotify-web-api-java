# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [2.0.0]
Complete rewrite of the library. The models and endpoints are generated from output of my [spotify-web-api-parser](https://github.com/sonallux/spotify-web-api) which generates a machine-readable format of the [Spotify Web API Reference](https://developer.spotify.com/documentation/web-api/reference). This results in a lot of breaking changes around naming of objects, properties, endpoints and parameters. 

Other notable changes:

- Renamed the maven groupId from `de.jsone-studios` to `de.sonallux.spotify`
- Renamed package from `de.jsone_studios.wrapper.spotify` to `de.sonallux.spotify.api`
- Removed `SpotifyApi` interface in favour of an updated `SpotifyWebApi` class
- `SpotifyWebApi` uses the builder pattern to create an instance
- Replaced [retrofit](https://square.github.io/retrofit) with a custom wrapper around [OkHttp](https://square.github.io/okhttp)
- Requests are now created with a builder style api for optional parameters. For example:
```java
ApiCall<?> call1 = spotifyWebApi.getXApi().getX("requiredParam").build();
ApiCall<?> call2 = spotifyWebApi.getXApi().getX("requiredParam").optionalParam1("Y").build();
```
- Removed `SpotifyApi.callApi()` in favour of an `executeCall()` method on the new `ApiCall` class
- Removed `SpotifyApi.callApiAndReturnBody()` in favour of an `execute()` method on the new `ApiCall` class
- Added support for all authorization flows. See [here](https://github.com/sonallux/spotify-web-api-java/tree/main#authorization) for more details.
- Bump minimum required Java version to Java 11

## [1.x.x]
The changelog of the `1.x.x` version of the `spotify-web-api-java` can be found on the [master branch](https://github.com/sonallux/spotify-web-api-java/blob/master/CHANGELOG.md).
