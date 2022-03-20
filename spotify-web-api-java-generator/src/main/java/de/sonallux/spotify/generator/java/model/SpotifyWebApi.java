package de.sonallux.spotify.generator.java.model;

import java.util.*;

public class SpotifyWebApi {
    private final Map<String, ApiCategory> categories = new LinkedHashMap<>();

    public ApiCategory getCategory(String name) {
        return categories.computeIfAbsent(name, ApiCategory::new);
    }

    public void addCategory(ApiCategory category) {
        categories.put(category.getName(), category);
    }

    public List<ApiCategory> getCategories() {
        var list = new ArrayList<>(categories.values());
        list.sort(Comparator.comparing(ApiCategory::getName));
        return list;
    }
}
