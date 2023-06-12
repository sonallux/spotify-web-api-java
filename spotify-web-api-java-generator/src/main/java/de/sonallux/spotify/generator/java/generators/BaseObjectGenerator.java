package de.sonallux.spotify.generator.java.generators;

import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.model.ApiObject;
import de.sonallux.spotify.generator.java.util.JavaUtils;

import java.util.List;
import java.util.Map;

public class BaseObjectGenerator extends ObjectGenerator {
    public static final String BASE_OBJECT_NAME = "BaseObject";
    public static final List<String> BASE_OBJECT_NAMES = List.of("Album", "Artist", "Episode", "Playlist", "Show", "Track", "User");
    public static final ApiObject BASE_API_OBJECT = ApiObject.builder()
            .name(BASE_OBJECT_NAME)
            .build()
            .addProperty(new ApiObject.Property("id",   "String", "The [Spotify ID](https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids) for the object."))
            .addProperty(new ApiObject.Property("type", "String", "The object type."))
            .addProperty(new ApiObject.Property("href", "String", "A link to the Web API endpoint providing full details of the object."))
            .addProperty(new ApiObject.Property("uri",  "String", "The [Spotify URI](https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids) for the object."));
    private static final List<String> BASE_OBJECT_PROPERTY_NAMES = List.of("id", "type", "href", "uri");

    public BaseObjectGenerator(GenerationContext generationContext) {
        super(generationContext);
    }

    private static boolean isChildOfBaseObject(List<Map<String, Object>> propertiesContext) {
        return propertiesContext.stream()
                .filter(p -> BASE_OBJECT_PROPERTY_NAMES.contains(p.get("fieldName")))
                .count() == BASE_OBJECT_PROPERTY_NAMES.size();
    }

    public static boolean removeBaseProperties(Map<String, Object> objectContext) {
        if (BASE_OBJECT_NAME.equals(objectContext.get("name"))) {
            return false;
        }
        var propertiesContext = (List<Map<String, Object>>) objectContext.get("properties");
        if (!isChildOfBaseObject(propertiesContext)) {
            return false;
        }
        propertiesContext.removeIf(p -> BASE_OBJECT_PROPERTY_NAMES.contains(p.get("fieldName")));
        return true;
    }

    public void generateBaseObject() {
        this.generateObject(BASE_API_OBJECT);
    }

    @Override
    protected void writeFile(String className, Map<String, Object> context) {
        context.put("className", BASE_OBJECT_NAME);

        var outputFile = modelsDirectory.resolve(JavaUtils.getFileName(BASE_OBJECT_NAME));
        generationContext.writeFile("base-object", outputFile, context);
    }
}
