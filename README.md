# spotify-web-api-java

[![Build Status](https://travis-ci.org/jsone-studios/spotify-web-api-java.svg?branch=master)](https://travis-ci.org/jsone-studios/spotify-web-api-java)

A Java wrapper for Spotify's Web API using [Retrofit](http://square.github.io/retrofit/)

## Usage
### Maven
```
<repositories>
    <repository>
        <id>jsone-studios-nexus</id>
        <url>https://nexus.jsone-studios.de/repository/maven-public</url>
    </repository>
</repositories>

<dependency>
    <groupId>jsone_studios.spotify-web-api-java</groupId>
    <artifactId>spotify-web-api-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
```
repositories {
    maven { url 'https://nexus.jsone-studios.de/repository/maven-public'}
}

dependencies {
    compile 'jsone_studios.spotify-web-api-java:spotify-web-api-java:1.0.0'
}    
```
