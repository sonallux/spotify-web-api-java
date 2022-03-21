package de.sonallux.spotify.generator.java.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ApiCategory {
    @Getter
    private final String name;
    private final List<ApiEndpoint> endpoints;

    public ApiCategory(String name, List<ApiEndpoint> endpoints) {
        this.name = name;
        this.endpoints = endpoints;
    }

    public ApiCategory(String name) {
        this(name, new ArrayList<>());
    }

    public ApiEndpoint getEndpointFromId(String id) {
        return endpoints.stream().filter(endpoint -> endpoint.getEndpointId().equals(id)).findFirst().orElseThrow();
    }

    public void addEndpoint(ApiEndpoint endpoint) {
        endpoints.add(endpoint);
    }

    public void removeEndpoint(ApiEndpoint endpoint) {
        endpoints.remove(endpoint);
    }

    public List<ApiEndpoint> getEndpoints() {
        var list = new ArrayList<>(endpoints);
        list.sort(Comparator.comparing(ApiEndpoint::getEndpointId));
        return list;
    }

}
