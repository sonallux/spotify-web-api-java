package de.sonallux.spotify.generator.java.generators;

import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.GeneratorException;
import de.sonallux.spotify.generator.java.model.ApiCategory;
import de.sonallux.spotify.generator.java.model.ApiEndpoint;
import de.sonallux.spotify.generator.java.model.SpotifyWebApi;
import de.sonallux.spotify.generator.java.util.JavaUtils;
import de.sonallux.spotify.generator.java.util.OpenApiUtils;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class ObjectModelCreator {
    private final GenerationContext generationContext;
    private final Function<String, String> responseTypeMapper;

    private SpotifyWebApi spotifyWebApi;

    public SpotifyWebApi createSpotifyWebApiModel(OpenAPI openAPI) {
        spotifyWebApi = new SpotifyWebApi();

        openAPI.getPaths().forEach(this::visitPathItem);

        return spotifyWebApi;
    }

    private void visitPathItem(String path, PathItem pathItem) {
        var categoryName = JavaUtils.getCategoryName(pathItem);
        var category = spotifyWebApi.getCategory(categoryName);

        pathItem.readOperationsMap().forEach((httpMethod, operation) -> visitOperation(category, httpMethod, path, operation));
    }

    private void visitOperation(ApiCategory category, PathItem.HttpMethod method, String path, Operation operation) {
        var endpointId = JavaUtils.shrinkOperationId(operation);
        var name = operation.getSummary().trim();
        var httpMethod = method.toString();
        var description = operation.getDescription();
        var response = generationContext.getResponse(operation);
        var responseType = getResponseType(response);
        var responseDescription = generationContext.resolveResponse(response).getDescription();
        var scopes = JavaUtils.getScopes(operation);

        var endpoint = new ApiEndpoint(endpointId, name, description, path, httpMethod, responseType, responseDescription, scopes);
        category.addEndpoint(endpoint);

        if (operation.getParameters() != null) {
            operation.getParameters().stream().map(generationContext::resolveParameter).forEach(parameter -> {
                switch (parameter.getIn()) {
                    case "path": {
                        endpoint.addPathParameter(convertParameter(parameter), parameter.getRequired());
                        break;
                    }
                    case "query": {
                        endpoint.addQueryParameter(convertParameter(parameter), parameter.getRequired());
                        break;
                    }
                }
            });
        }

        if (operation.getRequestBody() != null) {
            var requestBody = operation.getRequestBody();
            if (requestBody.getContent().containsKey("application/json")) {
                Schema<?> schema = requestBody.getContent().get("application/json").getSchema();
                var requiredParameters = schema.getRequired();
                schema.getProperties().forEach((String parameterName, Schema parameterSchema) -> {
                    var type = JavaUtils.getPrimitiveTypeOfSchema(parameterSchema)
                            .orElseThrow(() -> new GeneratorException("body parameter " + parameterName + " has unknown type: " + parameterSchema));
                    var isRequired = requiredParameters != null && requiredParameters.contains(parameterName);
                    var parameter = new ApiEndpoint.Parameter(parameterName, type, parameterSchema.getDescription());
                    endpoint.addBodyParameter(parameter, isRequired);
                });
            } else if (requestBody.getContent().containsKey("image/jpeg")) {
                var parameter = new ApiEndpoint.RawBodyParameter("base64Image", "String", requestBody.getDescription(), "image/jpeg");
                endpoint.addBodyParameter(parameter, requestBody.getRequired());
            }
        }
    }

    private ApiEndpoint.Parameter convertParameter(io.swagger.v3.oas.models.parameters.Parameter parameter) {
        var type = JavaUtils.getPrimitiveTypeOfSchema(parameter.getSchema())
                .orElseThrow(() -> new GeneratorException("parameter " + parameter.getName() + " has unknown type: " + parameter.getSchema()));
        return new ApiEndpoint.Parameter(parameter.getName(), type, parameter.getSchema().getDescription());
    }

    private String getResponseType(ApiResponse response) {
        if (response.get$ref() != null) {
            var responseName = OpenApiUtils.getResponseName(response.get$ref());
            var objectName = responseTypeMapper.apply(responseName);
            if (objectName != null) {
                return objectName;
            }
        }
        return "Void";
    }
}
