package de.sonallux.spotify.generator.java;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import de.sonallux.spotify.generator.java.util.OpenApiUtils;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardOpenOption.*;

@Getter
@RequiredArgsConstructor
public class GenerationContext {
    private static final String OPEN_API_OAUTH_SECURITY_SCHEME = "oauth_2_0";

    private final MustacheFactory mustacheFactory;
    private final OpenAPI openAPI;
    private final JavaPackage basePackage;
    private final Path outputDirectory;

    private final Map<String, Mustache> templates = new HashMap<>();

    public JavaPackage childPackage(String name) {
        return basePackage.child(name);
    }

    public Path getDirectoryForPackage(JavaPackage javaPackage) {
        return outputDirectory.resolve(javaPackage.getPath());
    }

    public void writeFile(String template, Path outputFile, Object context) {
        var mustacheTemplate = templates.computeIfAbsent(template, this::loadTemplate);
        try {
            Files.createDirectories(outputFile.getParent());
            try (var writer = Files.newBufferedWriter(outputFile, CREATE, TRUNCATE_EXISTING, WRITE)) {
                mustacheTemplate.execute(writer, context);
            }
        } catch (IOException e) {
            throw new GeneratorException("Failed to write file", e);
        }
    }

    private Mustache loadTemplate(String template) {
        return mustacheFactory.compile(String.format("templates/%s.mustache", template));
    }

    public SecurityScheme getSecurityScheme() {
        return openAPI.getComponents().getSecuritySchemes().get(OPEN_API_OAUTH_SECURITY_SCHEME);
    }

    public ApiResponse getResponse(Operation operation) {
        var responses = operation.getResponses();
        if (responses.containsKey("200")) {
            return responses.get("200");
        }
        if (responses.containsKey("201")) {
            return responses.get("201");
        }
        if (responses.containsKey("204")) {
            return responses.get("204");
        }
        return responses.getDefault();
    }

    public ApiResponse resolveResponse(ApiResponse response) {
        if (response.get$ref() == null) {
            return response;
        }
        return resolveResponse(response.get$ref());
    }

    public ApiResponse resolveResponse(String reference) {
        return openAPI.getComponents().getResponses().get(OpenApiUtils.getResponseName(reference));
    }

    public Parameter resolveParameter(Parameter parameter) {
        if (parameter.get$ref() == null) {
            return parameter;
        }
        return resolveParameter(parameter.get$ref());
    }

    public Parameter resolveParameter(String reference) {
        return openAPI.getComponents().getParameters().get(OpenApiUtils.getParameterName(reference));
    }

    public Schema<?> resolveSchema(Schema<?> schema) {
        if (schema.get$ref() == null) {
            return schema;
        }
        return resolveSchema(schema.get$ref());
    }

    public Schema<?> resolveSchema(String reference) {
        return openAPI.getComponents().getSchemas().get(OpenApiUtils.getSchemaName(reference));
    }
}
