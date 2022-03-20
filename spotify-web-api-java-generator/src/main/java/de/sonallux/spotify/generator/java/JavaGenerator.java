package de.sonallux.spotify.generator.java;

import com.github.mustachejava.MustacheFactory;
import de.sonallux.spotify.generator.java.generators.*;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class JavaGenerator {
    private final MustacheFactory mustacheFactory;

    public JavaGenerator() {
        this.mustacheFactory = new NoEscapingMustacheFactory();
    }

    public void generate(OpenAPI openAPI, Path outputDirectory, JavaPackage javaPackage) throws IOException, GeneratorException {
        var generationContext = new GenerationContext(this.mustacheFactory, openAPI, javaPackage, outputDirectory);

        new BaseObjectGenerator(generationContext).generateBaseObject();

        var objectGenerator = new ObjectGenerator(generationContext);
        objectGenerator.generateAllObjects();

        var objectModelCreator = new ObjectModelCreator(generationContext, objectGenerator::getObjectNameForResponse);
        var spotifyWebApi = objectModelCreator.createSpotifyWebApiModel(openAPI);

        EndpointSplitter.splitEndpoints(spotifyWebApi);

        var apiTemplate = new ApiGenerator(generationContext, objectGenerator::getObjectNameForResponse);
        apiTemplate.generateEndpoints(spotifyWebApi);

        new SpotifyWebApiGenerator(generationContext).generate();

        new ScopeGenerator(generationContext).generate();
    }
}
