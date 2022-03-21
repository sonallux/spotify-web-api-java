package de.sonallux.spotify.generator.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
public class ApiObject {
    /**
     * Name of the schema object from OpenAPI. Is null if this object is extracted from a complex OpenAPI schema
     */
    private String openApiName;
    @NonNull
    private String name;
    private String description;
    private String superClassName;
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
    @AllArgsConstructor
    public static class Property {
        @NonNull
        private String name;
        @NonNull
        private String type;
        private String description;
    }
}
