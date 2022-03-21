package de.sonallux.spotify.generator.java.model;

import de.sonallux.spotify.generator.java.util.JavaUtils;
import de.sonallux.spotify.generator.java.util.Markdown2Html;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ApiEndpoint {
    private final String endpointId;
    private final String name;
    private final String description;
    private final String path;
    private final String httpMethod;
    private final String responseType;
    private final String responseDescription;
    private final List<String> scopes;
    private final List<Parameter> requiredPathParameters;
    private final List<Parameter> requiredQueryParameters;
    private final List<Parameter> requiredBodyParameters;
    private final List<Parameter> optionalPathParameters;
    private final List<Parameter> optionalQueryParameters;
    private final List<Parameter> optionalBodyParameters;
    private RawBodyParameter rawBodyParameter = null;

    public ApiEndpoint(String endpointId, String name, String description, String path, String httpMethod, String responseType, String responseDescription, List<String> scopes) {
        this.endpointId = endpointId;
        this.name = name;
        this.description = description;
        this.path = path;
        this.httpMethod = httpMethod;
        this.responseType = responseType;
        this.responseDescription = responseDescription;
        this.scopes = scopes;
        this.requiredPathParameters = new ArrayList<>();
        this.requiredQueryParameters = new ArrayList<>();
        this.requiredBodyParameters = new ArrayList<>();
        this.optionalPathParameters = new ArrayList<>();
        this.optionalQueryParameters = new ArrayList<>();
        this.optionalBodyParameters = new ArrayList<>();
    }

    public void addPathParameter(Parameter parameter, boolean isRequired) {
        (isRequired ? requiredPathParameters : optionalPathParameters).add(parameter);
    }

    public void addQueryParameter(Parameter parameter, boolean isRequired) {
        (isRequired ? requiredQueryParameters : optionalQueryParameters).add(parameter);
    }

    public void addBodyParameter(Parameter parameter, boolean isRequired) {
        if (parameter instanceof RawBodyParameter rawBodyParameter) {
            if (!isRequired) {
                throw new IllegalArgumentException("RawBodyParameter can not be optional");
            }
            this.rawBodyParameter = rawBodyParameter;
        } else {
            (isRequired ? requiredBodyParameters : optionalBodyParameters).add(parameter);
        }
    }

    @Getter
    @Setter
    public static class Parameter {
        private final String name;
        private final String javaName;
        private String type;
        private String description;
        private String defaultValue;

        public Parameter(String name, String type, String description) {
            this.name = name;
            this.javaName = JavaUtils.escapeFieldName(name);
            this.type = type;
            this.description = Markdown2Html.convertToSingleLine(description);
            this.defaultValue = null;
        }

        public String asMethodParameter() {
            return type + " " + javaName;
        }

        public String asJavaDoc() {
            return "@param " + javaName + " " + Markdown2Html.convertToSingleLine(description);
        }
    }

    @Getter
    @Setter
    public static class RawBodyParameter extends Parameter {
        private String contentType;

        public RawBodyParameter(String name, String type, String description, String contentType) {
            super(name, type, description);
            this.contentType = contentType;
        }
    }
}
