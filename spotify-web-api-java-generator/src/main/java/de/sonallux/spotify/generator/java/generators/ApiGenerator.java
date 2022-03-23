package de.sonallux.spotify.generator.java.generators;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;
import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.model.ApiCategory;
import de.sonallux.spotify.generator.java.model.ApiEndpoint;
import de.sonallux.spotify.generator.java.model.SpotifyWebApi;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import de.sonallux.spotify.generator.java.util.JavaUtils;
import de.sonallux.spotify.generator.java.util.Markdown2Html;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class ApiGenerator {
    private final GenerationContext generationContext;

    private JavaPackage apisJavaPackage;

    public void generateEndpoints(SpotifyWebApi spotifyWebApi) {
        apisJavaPackage = generationContext.childPackage("apis");

        spotifyWebApi.getCategories().forEach(this::generateApiClasses);
    }

    private void generateApiClasses(ApiCategory category) {
        var className = JavaUtils.getCategoryClassName(category.getName());
        var requestsJavaPackage = apisJavaPackage.child(JavaUtils.getCategoryPackageName(category.getName()));

        var context = new HashMap<String, Object>();
        context.put("package", apisJavaPackage.getName());
        context.put("requestsPackage", requestsJavaPackage.getName());
        context.put("name", category.getName());
        context.put("className", className);
        context.put("endpoints", category.getEndpoints().stream().map(endpoint -> buildEndpointContext(endpoint, requestsJavaPackage)).toList());

        var packageDirectory = generationContext.getDirectoryForPackage(apisJavaPackage);
        var outputFile = packageDirectory.resolve(JavaUtils.getFileName(className));
        generationContext.writeFile("api", outputFile, context);
    }

    private Map<String, Object> buildEndpointContext(ApiEndpoint endpoint, JavaPackage javaPackage) {
        List<ApiEndpoint.Parameter> requiredParameters = generateEndpointRequest(endpoint, javaPackage);

        var context = new HashMap<String, Object>();
        var methodName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, endpoint.getEndpointId());
        context.put("methodName", methodName);
        context.put("name", endpoint.getName());
        context.put("description", Markdown2Html.convertToSingleLine(endpoint.getDescription()));
        context.put("requestBuilder", JavaUtils.getEndpointRequestBuilderName(endpoint.getEndpointId()));

        context.put("requiredParameters", requiredParameters.stream()
                .map(ApiEndpoint.Parameter::asMethodParameter)
                .collect(joining(", ")));
        context.put("javaDocParameters", requiredParameters.stream()
                .map(ApiEndpoint.Parameter::asJavaDoc)
                .collect(toList()));

        context.put("arguments", Stream.concat(Stream.of(new ApiEndpoint.Parameter("apiClient", "ApiClient", "")), requiredParameters.stream())
                .map(ApiEndpoint.Parameter::getJavaName)
                .collect(joining(", ")));

        return context;
    }

    private List<ApiEndpoint.Parameter> generateEndpointRequest(ApiEndpoint endpoint, JavaPackage javaPackage) {
        fixDuplicateEndpointParameters(endpoint);

        var className = JavaUtils.getEndpointRequestBuilderName(endpoint.getEndpointId());

        var context = new HashMap<String, Object>();
        context.put("package", javaPackage.getName());
        context.put("name", endpoint.getName() + " request");
        context.put("className", className);
        context.put("httpMethod", endpoint.getHttpMethod());
        context.put("path", endpoint.getPath());
        context.put("responseType", endpoint.getResponseType());
        context.put("responseDescription", Markdown2Html.convertToLines(endpoint.getResponseDescription()));
        if (!endpoint.getScopes().isEmpty()) {
            context.put("scopes", String.join(", ", endpoint.getScopes()));
        }

        context.put("requiredPathParameters", endpoint.getRequiredPathParameters());
        context.put("requiredQueryParameters", endpoint.getRequiredQueryParameters());
        context.put("requiredBodyParameters", endpoint.getRequiredBodyParameters());
        context.put("optionalPathParameters", endpoint.getOptionalPathParameters());
        context.put("optionalQueryParameters", endpoint.getOptionalQueryParameters());
        context.put("optionalBodyParameters", endpoint.getOptionalBodyParameters());
        context.put("rawBodyParameter", endpoint.getRawBodyParameter());

        List<ApiEndpoint.Parameter> requiredParameterList = new ArrayList<>();
        requiredParameterList.add(new ApiEndpoint.Parameter("apiClient", "ApiClient", "The API client"));
        requiredParameterList.addAll(endpoint.getRequiredPathParameters());
        requiredParameterList.addAll(endpoint.getRequiredQueryParameters());
        requiredParameterList.addAll(endpoint.getRequiredBodyParameters());
        if (endpoint.getRawBodyParameter() != null) {
            requiredParameterList.add(endpoint.getRawBodyParameter());
        }
        context.put("requiredParameters", requiredParameterList.stream()
                .map(ApiEndpoint.Parameter::asMethodParameter)
                .collect(joining(", ")));

        context.put("requiredJavaDocParameters", requiredParameterList.stream().map(ApiEndpoint.Parameter::asJavaDoc).toList());

        endpoint.getOptionalQueryParameters().stream()
                .filter(p -> "additional_types".equals(p.getName()))
                .findFirst().ifPresent(additionalTypesParameter -> {
                    additionalTypesParameter.setDefaultValue("\"track,episode\"");
                    context.put("parametersWithDefaultValue", List.of(additionalTypesParameter));
                });

        var packageDirectory = generationContext.getDirectoryForPackage(javaPackage);
        var outputFile = packageDirectory.resolve(JavaUtils.getFileName(className));
        generationContext.writeFile("request", outputFile, context);

        return requiredParameterList.subList(1, requiredParameterList.size());
    }

    /**
     * Fixes duplicated endpoint parameters.
     * Some endpoints allow passing data either via query argument or via body. As the url has a length limit,
     * passing too much data in the query string might result in an error response. Therefore, this method removes
     * the option to pass the data via query argument and makes the body parameter mandatory.
     * @param endpoint the spotify api endpoint to fix
     */
    public void fixDuplicateEndpointParameters(ApiEndpoint endpoint) {
        var allBodyParameters = new HashSet<String>();
        endpoint.getRequiredBodyParameters().forEach(p -> allBodyParameters.add(p.getName()));
        endpoint.getOptionalBodyParameters().forEach(p -> allBodyParameters.add(p.getName()));

        var allQueryParameters = new HashSet<String>();
        endpoint.getRequiredQueryParameters().forEach(p -> allQueryParameters.add(p.getName()));
        endpoint.getOptionalQueryParameters().forEach(p -> allQueryParameters.add(p.getName()));

        var duplicateParameterNames = Sets.intersection(allBodyParameters, allQueryParameters);
        if (duplicateParameterNames.isEmpty()) {
            return;
        }

        endpoint.getRequiredQueryParameters().removeIf(p -> duplicateParameterNames.contains(p.getName()));
        endpoint.getOptionalQueryParameters().removeIf(p -> duplicateParameterNames.contains(p.getName()));

        for (var iterator = endpoint.getOptionalBodyParameters().iterator(); iterator.hasNext(); ) {
            var optionalBodyParameter = iterator.next();

            // Parameter position in endpoint-add-tracks-to-playlist is optional
            if ("add-tracks-to-playlist".equals(endpoint.getEndpointId()) && "position".equals(optionalBodyParameter.getName())) {
                continue;
            }

            if (duplicateParameterNames.contains(optionalBodyParameter.getName())) {
                iterator.remove();
                endpoint.getRequiredBodyParameters().add(optionalBodyParameter);
            }
        }
    }
}
