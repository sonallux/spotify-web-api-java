package de.sonallux.spotify.generator.java.util;

import com.google.common.base.CaseFormat;
import de.sonallux.spotify.generator.java.generators.BaseObjectGenerator;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

@Slf4j
public class JavaUtils {
    public static final List<String> RESERVED_WORDS = Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "do", "double",
            "else", "enum", "extends", "false", "final", "finally", "float", "for",
            "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "null", "package", "private", "protected", "public", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "true", "try",
            "var", "void", "volatile", "while"
    );

    public static String getFileName(String className) {
        return className + ".java";
    }

    public static String escapeFieldName(String fieldName) {
        if (RESERVED_WORDS.contains(fieldName)) {
            return "_" + fieldName;
        }
        if (fieldName.contains("_")) {
            return LOWER_UNDERSCORE.converterTo(LOWER_CAMEL).convert(fieldName);
        }
        return fieldName;
    }

    public static String shrinkOperationId(Operation operation) {
        return operation.getOperationId()
                .replace("-the-", "-")
                .replace("-an-", "-")
                .replace("-a-", "-");
    }

    public static Optional<String> getPrimitiveTypeOfSchema(Schema<?> schema) {
        if ("boolean".equals(schema.getType())) {
            return Optional.of("boolean");
        } else if ("integer".equals(schema.getType())) {
            if ("int64".equals(schema.getFormat())) {
                return Optional.of("long");
            }
            // if no format is present, use 32bit integer, for compatability reasons
            return Optional.of("int");
        } else if ("number".equals(schema.getType())) {
            if ("double".equals(schema.getFormat())) {
                return Optional.of("double");
            }
            // if no format is present, use single precision floating point number, for compatability reasons
            return Optional.of("float");
        } else {
            return getTypeOfSchema(schema);
        }
    }

    public static Optional<String> getTypeOfSchema(Schema<?> schema) {
        if (schema.get$ref() != null) {
            return Optional.of(OpenApiUtils.getSchemaName(schema.get$ref()).replace("Object", ""));
        }
        if ("string".equals(schema.getType())) {
            if ("date-time".equals(schema.getFormat())) {
                return Optional.of("java.time.Instant");
            }
            return Optional.of("String");
        }
        if ("integer".equals(schema.getType())) {
            if ("int64".equals(schema.getFormat())) {
                return Optional.of("Long");
            }
            // if no format is present, use 32bit integer, for compatability reasons
            return Optional.of("Integer");
        }
        if ("boolean".equals(schema.getType())) {
            return Optional.of("Boolean");
        }
        if ("number".equals(schema.getType())) {
            if ("double".equals(schema.getFormat())) {
                return Optional.of("Double");
            }
            // if no format is present, use single precision floating point number, for compatability reasons
            return Optional.of("Float");
        }
        switch (schema) {
            case ArraySchema arraySchema -> {
                return getTypeOfSchema(arraySchema.getItems())
                    .map(itemsType -> "java.util.List<" + itemsType + ">")
                    .or(() -> Optional.of("java.util.List<java.util.Map<String, Object>>"));
            }
            case ComposedSchema composedSchema -> {
                var allOf = composedSchema.getAllOf();
                if (allOf != null) {
                    if (allOf.size() == 1) {
                        if (allOf.getFirst().get$ref().equals("#/components/schemas/PagingObject")) {
                            var itemsSchema = (ArraySchema) schema.getProperties().get("items");
                            return getTypeOfSchema(itemsSchema.getItems())
                                .map(itemsType -> "Paging<" + itemsType + ">");
                        }
                    }
                    if (allOf.size() == 2) {
                        if (allOf.get(0).get$ref().equals("#/components/schemas/PagingObject")) {
                            var itemsSchema = (ArraySchema) allOf.get(1).getProperties().get("items");
                            return getTypeOfSchema(itemsSchema.getItems())
                                .map(itemsType -> "Paging<" + itemsType + ">");
                        }
                        if (allOf.get(0).get$ref().equals("#/components/schemas/CursorPagingObject")) {
                            var itemsSchema = (ArraySchema) allOf.get(1).getProperties().get("items");
                            return getTypeOfSchema(itemsSchema.getItems())
                                .map(itemsType -> "CursorPaging<" + itemsType + ">");
                        }
                    }
                }

                var oneOf = composedSchema.getOneOf();
                if (oneOf != null) {
                    var allBaseObjects = oneOf.stream().map(JavaUtils::getTypeOfSchema)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .allMatch(BaseObjectGenerator.BASE_OBJECT_NAMES::contains);
                    if (allBaseObjects) {
                        return Optional.of("BaseObject");
                    }
                }

                // Resolve type of other composed schema via reference name
                return Optional.empty();
            }
            case MapSchema ignored -> {
                return Optional.of("java.util.Map<String, Object>");
            }
            default -> {
                return Optional.empty();
            }
        }
    }

    public static String getCategoryName(Operation operation) {
        return operation.getTags().getFirst();
    }

    public static String getCategoryClassName(String categoryName) {
        return categoryName.replace(" ", "") + "Api";
    }

    public static String getCategoryPackageName(String categoryName) {
        return categoryName.replace(" ", "").toLowerCase();
    }

    public static String getEndpointRequestBuilderName(String endpointId) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, endpointId) + "Request";
    }

    public static List<String> getScopes(Operation operation) {
        var security = operation.getSecurity();
        if (security.isEmpty()) {
            return List.of();
        }
        return security.getFirst().getOrDefault("oauth_2_0", List.of());
    }
}
