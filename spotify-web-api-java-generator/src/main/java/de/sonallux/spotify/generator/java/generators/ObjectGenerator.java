package de.sonallux.spotify.generator.java.generators;

import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.model.ApiObject;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import de.sonallux.spotify.generator.java.util.JavaUtils;
import de.sonallux.spotify.generator.java.util.Markdown2Html;
import de.sonallux.spotify.generator.java.util.OpenApiUtils;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.google.common.base.CaseFormat.*;

public class ObjectGenerator {
    protected final GenerationContext generationContext;
    protected final JavaPackage modelsPackage;
    protected final Path modelsDirectory;

    // object name to object definition
    private final Map<String, ApiObject> schemaObjects;
    // OpenAPI response name to object name
    private final Map<String, String> responseNameToObjectName;
    // OpenAPI schema name to object name
    private final Map<String, String> schemaNameToObjectName;

    public ObjectGenerator(GenerationContext generationContext) {
        this.generationContext = generationContext;
        this.modelsPackage = generationContext.childPackage("models");
        this.modelsDirectory = generationContext.getDirectoryForPackage(modelsPackage);
        this.schemaObjects = new ConcurrentHashMap<>();
        this.responseNameToObjectName = new ConcurrentHashMap<>();
        this.schemaNameToObjectName = new ConcurrentHashMap<>();
    }

    public String getObjectNameForResponse(String responseName) {
        return responseNameToObjectName.get(responseName);
    }

    private String getObjectNameFromSchemaName(String schemaName) {
        return schemaName.replace("Object", "");
    }

    private String getObjectNameFrom$Ref(String reference) {
        return getObjectNameFromSchemaName(OpenApiUtils.getSchemaName(reference));
    }

    public void generateAllObjects() {
        generationContext.getOpenAPI().getComponents().getResponses().forEach((name, response) -> {
            var schema = response.getContent().get("application/json").getSchema();
            var objectName = generateApiObject(name, schema);
            this.responseNameToObjectName.put(name, objectName);
        });

        generationContext.getOpenAPI().getComponents().getSchemas().forEach(this::getObjectNameOrGenerate);

        schemaObjects.values().forEach(this::generateObject);
    }

    /**
     *
     * @param openApiName the OpenAPI name
     * @param schema the OpenAPI schema
     * @return an object name to use for this schema
     */
    private String generateApiObject(String openApiName, Schema schema) {
        if (schema.get$ref() != null) {
            var schemaName = OpenApiUtils.getSchemaName(schema.get$ref());
            return getObjectNameOrGenerate(schemaName, generationContext.resolveSchema(schema.get$ref()));
        }

        var objectName = getObjectNameFromSchemaName(openApiName);

        if (schema instanceof ObjectSchema objectSchema) {
            var apiObject = generateApiObject(objectSchema, objectName);
            apiObject.setOpenApiName(openApiName);
            return objectName;
        }
        if (schema instanceof ArraySchema arraySchema) {
            var itemsSchema = arraySchema.getItems();
            var itemsType = JavaUtils.getTypeOfSchema(itemsSchema).orElse("Object");

            return "java.util.List<" + itemsType + ">";
        }
        if (schema instanceof ComposedSchema composedSchema) {
            if (composedSchema.getAllOf() != null) {
                var allOf = composedSchema.getAllOf();
                if (allOf.size() == 1) {
                    if (allOf.get(0).get$ref() != null) {
                        var referencedSchemaName = OpenApiUtils.getSchemaName(allOf.get(0).get$ref());
                        var referencedObjectName = getObjectNameOrGenerate(referencedSchemaName, allOf.get(0));
                        var apiObject = ApiObject.builder()
                                .name(objectName)
                                .openApiName(openApiName)
                                .superClassName(referencedObjectName)
                                .description(composedSchema.getDescription())
                                .build();
                        this.schemaObjects.put(objectName, apiObject);
                        return objectName;
                    }
                }
                if (allOf.size() == 2) {
                    if (allOf.get(0).get$ref().equals("#/components/schemas/PagingObject")) {
                        var itemsSchema = (ArraySchema) allOf.get(1).getProperties().get("items");
                        var itemsSchemaName = OpenApiUtils.getSchemaName(itemsSchema.getItems().get$ref());
                        var itemsObjectName = getObjectNameOrGenerate(itemsSchemaName, itemsSchema.getItems());
                        return "Paging<" + itemsObjectName + ">";
                    }
                    if (allOf.get(0).get$ref().equals("#/components/schemas/CursorPagingObject")) {
                        var itemsSchema = (ArraySchema) allOf.get(1).getProperties().get("items");
                        var itemsSchemaName = OpenApiUtils.getSchemaName(itemsSchema.getItems().get$ref());
                        var itemsObjectName = getObjectNameOrGenerate(itemsSchemaName, itemsSchema.getItems());
                        return "CursorPaging<" + itemsObjectName + ">";
                    }

                    if (allOf.get(0).get$ref() != null && allOf.get(1) instanceof ObjectSchema objectSchema) {
                        var referencedSchemaName = OpenApiUtils.getSchemaName(allOf.get(0).get$ref());
                        var referencedObjectName = getObjectNameOrGenerate(referencedSchemaName, allOf.get(0));

                        var apiObject = generateApiObject(objectSchema, objectName);
                        apiObject.setDescription(composedSchema.getDescription());
                        apiObject.setOpenApiName(openApiName);
                        apiObject.setSuperClassName(referencedObjectName);
                        return objectName;
                    }
                }
            }
        }


        return objectName;
    }

    private ApiObject generateApiObject(ObjectSchema objectSchema, String objectName) {
        return schemaObjects.computeIfAbsent(objectName, name -> {
            var apiObject = ApiObject.builder()
                    .name(objectName)
                    .description(objectSchema.getDescription())
                    .build();

            objectSchema.getProperties().entrySet().stream()
                    .map(entry -> generateApiObjectProperty(objectName, entry.getKey(), entry.getValue()))
                    .forEach(apiObject::addProperty);
            return apiObject;
        });
    }

    private ApiObject.Property generateApiObjectProperty(String objectName, String name, Schema<?> schema) {
        var resolvedSchema = generationContext.resolveSchema(schema);
        if (resolvedSchema instanceof ObjectSchema objectSchema) {
            var innerObjectName = objectName + LOWER_UNDERSCORE.converterTo(UPPER_CAMEL).convert(name);
            generateApiObject(objectSchema, innerObjectName);
            return new ApiObject.Property(name, innerObjectName, resolvedSchema.getDescription());
        }
        if (resolvedSchema instanceof ComposedSchema composedSchema && composedSchema.getAllOf() != null && composedSchema.getAllOf().size() == 1) {
            var innerSchemaName = OpenApiUtils.getSchemaName(composedSchema.getAllOf().get(0).get$ref());
            var innerSchema = generationContext.resolveSchema(composedSchema.getAllOf().get(0).get$ref());
            var innerType = JavaUtils.getPrimitiveTypeOfSchema(innerSchema)
                    .orElse(innerSchemaName.replace("Object", ""));

            return new ApiObject.Property(name, innerType, firstNonNull(resolvedSchema.getDescription(), innerSchema.getDescription()));
        }
        return new ApiObject.Property(name, JavaUtils.getPrimitiveTypeOfSchema(resolvedSchema).orElse("Object"), resolvedSchema.getDescription());
    }

    private String getObjectNameOrGenerate(String openApiName, Schema schema) {
        if (schemaNameToObjectName.containsKey(openApiName)) {
            return schemaNameToObjectName.get(openApiName);
        }
        var objectName = generateApiObject(openApiName, schema);

        schemaNameToObjectName.put(openApiName, objectName);
        return objectName;
    }

    public void generateObject(ApiObject apiObject) {
        var context = new HashMap<String, Object>();
        context.put("package", modelsPackage.getName());
        context.put("name", apiObject.getOpenApiName());
        context.put("className", apiObject.getName());

        context.put("properties", apiObject.getPropertyList().stream()
                .map(this::buildPropertyContext)
                .collect(Collectors.toList())
        );

        if (!BaseObjectGenerator.BASE_OBJECT_NAME.equals(apiObject.getName())) {
            if (apiObject.getSuperClassName() == null) {
                if (BaseObjectGenerator.removeBaseProperties(context)) {
                    context.put("extendsBaseObject", true);
                    context.put("superClass", BaseObjectGenerator.BASE_OBJECT_NAME);
                }
            } else {
                context.put("superClass", apiObject.getSuperClassName());
            }
        }

        if ("Paging".equals(apiObject.getName()) || "CursorPaging".equals(apiObject.getName())) {
            fixContextForPaging(context);
        }

        writeFile(apiObject.getName(), context);
    }

    protected void writeFile(String className, Map<String, Object> context) {
        var outputFile = modelsDirectory.resolve(JavaUtils.getFileName(className));
        generationContext.writeFile("object", outputFile, context);
    }

    private Map<String, Object> buildPropertyContext(ApiObject.Property property) {
        var context = new HashMap<String, Object>();
        var propertyName = property.getName();
        if (JavaUtils.RESERVED_WORDS.contains(propertyName)) {
            context.put("isReservedKeywordProperty", true);
            context.put("fieldName", "_" + propertyName);
        } else {
            // spotify property names are in lower underscore case (e.g album_type)
            // but java convention is lower camel case for fields, therefore transform
            // JsonProperty annotation is not needed, because the object mapper is configured
            // with the correct property naming strategy
            context.put("fieldName", LOWER_UNDERSCORE.converterTo(LOWER_CAMEL).convert(propertyName));
        }

        if (property.getDescription() != null) {
            context.put("hasDescription", true);
            context.put("description", Markdown2Html.convertToLines(property.getDescription()));
        }

        context.put("type", property.getType());

        return context;
    }

    private void fixContextForPaging(Map<String, Object> context) {
        context.put("className", context.get("className") + "<T>");
        @SuppressWarnings("unchecked")
        var properties = (List<Map<String, Object>>)context.get("properties");
        for (var property : properties) {
            if ("items".equals(property.get("fieldName"))) {
                property.put("type", "java.util.List<T>");
            }
        }
    }

    private static String firstNonNull(String... strings) {
        for (var s : strings) {
            if (s != null) {
                return s;
            }
        }
        return null;
    }
}
