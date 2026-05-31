package de.sonallux.spotify.generator.java.model;

import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Builder
public class ApiObject {
    /**
     * Name of the schema object from OpenAPI. Is null if this object is extracted from a complex OpenAPI schema
     */
    private @Nullable String openApiName;
    private String name;
    private @Nullable String description;
    private @Nullable String superClassName;
    @Builder.Default
    private Map<String, Property> properties = new HashMap<>();

    public ApiObject addProperty(Property property) {
        this.properties.put(property.getName(), property);
        return this;
    }

    public List<Property> getPropertyList() {
        return properties.values().stream()
                .sorted(Comparator.comparing(Property::getName))
                .collect(Collectors.toList());
    }

    @Data
    public static class Property {
        private String name;
        private String type;
        @Nullable
        private String description;
        private boolean deprecated;

        public Property(String name, String type, @Nullable String description) {
            this(name, type, description, false);
        }

        public Property(String name, String type, @Nullable String description, @Nullable Boolean deprecated) {
            this.name = name;
            this.type = type;
            this.description = description;
            this.deprecated = Objects.requireNonNullElse(deprecated, false);
        }
    }
}
