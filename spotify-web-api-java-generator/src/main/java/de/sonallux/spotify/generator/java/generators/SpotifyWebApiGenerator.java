package de.sonallux.spotify.generator.java.generators;

import com.google.common.base.CaseFormat;
import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import de.sonallux.spotify.generator.java.util.JavaUtils;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class SpotifyWebApiGenerator {
    private final GenerationContext generationContext;

    public void generate() {
        var javaPackage = generationContext.getBasePackage();

        var context = createContext(generationContext.getOpenAPI(), javaPackage);

        var outputFile = generationContext.getDirectoryForPackage(javaPackage).resolve("SpotifyWebApi.java");
        generationContext.writeFile("spotify-web-api", outputFile, context);
    }

    private Map<String, Object> createContext(OpenAPI openAPI, JavaPackage javaPackage) {
        var context = new HashMap<String, Object>();
        context.put("package", javaPackage.getName());
        context.put("endpointUrl", openAPI.getServers().getFirst().getUrl());

        var apis = openAPI.getPaths().values().stream()
                .flatMap(pathItem -> pathItem.readOperationsMap().values().stream())
                .map(JavaUtils::getCategoryName)
                .map(JavaUtils::getCategoryClassName)
                .distinct()
                .sorted()
                .map(className -> Map.of("className", className, "fieldName", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, className)))
                .toList();

        context.put("apis", apis);
        return context;
    }
}
