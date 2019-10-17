# spotify-web-api-java

[![Build Status](https://travis-ci.com/jsone-studios/spotify-web-api-java.svg?branch=master)](https://travis-ci.com/jsone-studios/spotify-web-api-java)
[![Maven Central](https://img.shields.io/maven-central/v/de.jsone-studios/spotify-web-api-java)](https://search.maven.org/search?q=g:%22de.jsone-studios%22%20AND%20a:%22spotify-web-api-java%22)
[![GitHub](https://img.shields.io/github/license/jsone-studios/spotify-web-api-java)](https://github.com/jsone-studios/spotify-web-api-java/blob/master/LICENSE)
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=jsone-studios/spotify-web-api-java)](https://dependabot.com)

A Java wrapper for Spotify's Web API using [Retrofit](http://square.github.io/retrofit/)

## Usage
`spotify-web-api-java` is available on Maven Central.

### Maven
```
<dependency>
    <groupId>de.jsone-studios</groupId>
    <artifactId>spotify-web-api-java</artifactId>
    <version>1.2.0</version>
</dependency>
```

### Gradle
```
dependencies {
    compile 'de.jsone-studios:spotify-web-api-java:1.2.0'
}    
```

## Deploy a new release to Maven Central
- Update version number
- Run `mvn clean deploy -Pdeploy`
- Update version number to next SNAPSHOT version