package de.sonallux.spotify.generator.java;

import java.nio.file.Path;

public class JavaGeneratorTest {
    private static final Path OPEN_API_FILE = Path.of("spotify-web-api-java-generator", "fixed-spotify-open-api.yml");
    private static final Path OUTPUT_FOLDER = Path.of("spotify-web-api-java", "src", "main", "generated");
    private static final String JAVA_PACKAGE_NAME = "de.sonallux.spotify.api";

    public static void main(String[] args) {
        var cli = new CLI();
        cli.openApiFile = OPEN_API_FILE;
        cli.outputFolder = OUTPUT_FOLDER;
        cli.packageName = JAVA_PACKAGE_NAME;
        cli.shouldClean = true;
        cli.run();
    }
}
