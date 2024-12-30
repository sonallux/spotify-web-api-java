# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

- Fix type attribute for `SearchRequest`. Different types are now concatenated by ",".

## [4.3.0]

- `UsersApi#checkIfUserFollowsPlaylist` remove `ids` argument as only the current use can be checked
- Adjust type of `artists` property in `Track` object from `Artist` to `SimplifiedArtist`
- Bump jackson to `2.18.1`

## [4.2.0]

- Remove no longer supported `country` query parameter
- Fix generation for 64bit integers [#262](https://github.com/sonallux/spotify-web-api-java/pull/262)
- Bump jackson to `2.16.1`

## [4.1.0]

- Introduce `ArtistDiscographyAlbum` as response for get Artist's Albums request
- Rename model `Devices` into `ManyDevices`
- Remove unused `PlayerError` and `TuneableTrack` models
- Bump jackson to `2.16.0`
- Bump okhttp to `4.12.0`

## [4.0.1]

- Update links to Spotify documentation

## [4.0.0]

- Adjust the categories of some endpoints to match with the
  official [Spotify Web API Reference](https://developer.spotify.com/documentation/web-api). No endpoint have been
  removed, they just got moved to other categories.
    - Added `CategoriesApi` and `GenresApi` category
    - Removed `BrowseApe`, `LibraryApi` and `PersonalizationApi`
    - Renamed `UsersProfileApi` to `UsersApi`
- Add "Get an Audiobook's Chapters" endpoint
- Add "Get User's Saved Audiobooks" endpoint
- Add "Save Audiobooks for Current User" endpoint
- Add "Remove User's Saved Audiobooks" endpoint
- Add "Check User's Saved Audiobooks" endpoint
- Fix type of `shuffleState` in `CurrentlyPlayingContext` to `boolean`
- Fix return type of "Get Category's Playlists request" from `PagedPlaylists` to `PagingFeaturedPlaylist`
- Fix return type of "Get Featured Playlists request" from `PagedPlaylistsAndMessage` to `PagingFeaturedPlaylist`
- Fix type of `narrators` field in `AudiobookBase` from `Narrator` to `List<Narrator>`
- Bump jackson to `2.15.2`
- Bump okhttp to `4.11.0`

## [3.1.0]

- Change the API of the recommendations request. All `seed*` parameters are now considered optional because not all of
  them are always required. It must be at least one `seed*` parameter present.
- Add player's get queue request
- Add audiobooks and chapters API
- Bump jackson to `2.13.4`

## [3.0.1]

- Fix type of artists property of Album to SimplifiedArtist
- Bump jackson-databind from 2.13.2 to 2.13.2.2

## [3.0.0]

The Java wrapper generator has been completely rewritten and uses now OpenAPI definition of the Spotify Web API as
source.
The OpenAPI definition contains fixes and improvements from
my [spotify-web-api](https://github.com/sonallux/spotify-web-api) repository.
Therefore, some model class names have changed and many fixes are included.

- The library now also requires Java 17
- Update to jackson `2.13.2` and jackson-databind to `2.13.2.1` to fix CVE-2020-36518
- Update to okhttp `4.9.3`

## [2.4.0]

- Update to spotify-web-api-core `2021.10.17`
    - Mark `market` parameter in "Get Artist's Top Tracks" endpoint as optional
    - Mark `market` parameter in "Get User's Currently Playing Track" endpoint as optional
- Update to okhttp `4.9.2`
- Update to jackson `2.12.5`

## [2.3.0]

- Update to spotify-web-api-core `2021.8.23`
    - Fix `tracks` property in `Recommendations`
    - Mark `market` parameter in "Get Playlist's Items" endpoint as optional
    - Make "Upload a Custom Playlist Cover Image" endpoint actually usable
    - Make type of `tracks` parameter in "Remove Items from a Playlist" endpoint more accurate
- Update to jackson `2.12.4`

## [2.2.0]

- Update to spotify-web-api-core `2021.6.18`
    - Fix response type of `ReplacePlaylistsTracksRequest` from `Void` to `SnapshotId`.
- Add a module-info file, so the library is usable with the Java module system.

## [2.1.0]

- Update to spotify-web-api-core `2021.5.1`
    - The `ids` parameter in the `RemoveShowsUserRequest` and `SaveShowsUserRequest` is now passed in the body
    - Add `htmlDescription` and `restrictions` fields to `Episode` and `SimplifiedEpisode`
    - Fix `SearchResponse` object

## [2.0.0]

Complete rewrite of the library. The models and endpoints are generated from output of
my [spotify-web-api-parser](https://github.com/sonallux/spotify-web-api) which generates a machine-readable format of
the [Spotify Web API Reference](https://developer.spotify.com/documentation/web-api/reference). This results in a lot of
breaking changes around naming of objects, properties, endpoints and parameters.

Other notable changes:

- Renamed the maven groupId from `de.jsone-studios` to `de.sonallux.spotify`
- Renamed package from `de.jsone_studios.wrapper.spotify` to `de.sonallux.spotify.api`
- Removed `SpotifyApi` interface in favour of an updated `SpotifyWebApi` class
- `SpotifyWebApi` uses the builder pattern to create an instance
- Replaced [retrofit](https://square.github.io/retrofit) with a custom wrapper
  around [OkHttp](https://square.github.io/okhttp)
- Requests are now created with a builder style api for optional parameters. For example:

```java
ApiCall<?> call1 = spotifyWebApi.getXApi().getX("requiredParam").build();
ApiCall<?> call2 = spotifyWebApi.getXApi().getX("requiredParam").optionalParam1("Y").build();
```

- Removed `SpotifyApi.callApi()` in favour of an `executeCall()` method on the new `ApiCall` class
- Removed `SpotifyApi.callApiAndReturnBody()` in favour of an `execute()` method on the new `ApiCall` class
- Added support for all authorization flows.
  See [here](https://github.com/sonallux/spotify-web-api-java/tree/main#authorization) for more details.
- Bump minimum required Java version to Java 11

## [1.x.x]

The changelog of the `1.x.x` version of the `spotify-web-api-java` can be found on
the [1.x branch](https://github.com/sonallux/spotify-web-api-java/blob/1.x/CHANGELOG.md).
