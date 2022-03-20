package de.sonallux.spotify.generator.java.util;

import de.sonallux.spotify.generator.java.GeneratorException;

public class OpenApiUtils {
    public static String getSchemaName(String reference) {
        if (!reference.startsWith("#/components/schemas/")) {
            throw new GeneratorException("Expected schema reference but got " + reference);
        }
        return reference.substring(21);
    }

    public static String getParameterName(String reference) {
        if (!reference.startsWith("#/components/parameters/")) {
            throw new GeneratorException("Expected parameter reference but got " + reference);
        }
        return reference.substring(24);
    }

    public static String getResponseName(String reference) {
        if (!reference.startsWith("#/components/responses/")) {
            throw new GeneratorException("Expected response reference but got " + reference);
        }
        return reference.substring(23);
    }
}
