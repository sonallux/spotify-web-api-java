package de.sonallux.spotify.generator.java.generators;

import com.google.common.base.CaseFormat;
import de.sonallux.spotify.generator.java.GenerationContext;
import de.sonallux.spotify.generator.java.util.JavaPackage;
import io.swagger.v3.oas.models.security.Scopes;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ScopeGenerator {
    private final GenerationContext generationContext;

    public void generate() {
        var javaPackage = generationContext.childPackage("authorization");

        var scopes = generationContext.getSecurityScheme().getFlows().getAuthorizationCode().getScopes();
        var context = createScope(scopes, javaPackage);

        var outputFile = generationContext.getDirectoryForPackage(javaPackage).resolve("Scope.java");
        generationContext.writeFile("scope", outputFile, context);
    }

    private Map<String, Object> createScope(Scopes scopes, JavaPackage javaPackage) {
        var context = new HashMap<String, Object>();
        context.put("package", javaPackage.getName());
        context.put("className", "Scope");

        var scopesContext = scopes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(scopeEntry -> new HashMap<>(Map.of(
                        "name", scopeEntry.getKey(),
                        "enumName", CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, scopeEntry.getKey()),
                        "description", scopeEntry.getValue().trim(),
                        "last", false
                )))
                .toList();
        scopesContext.get(scopes.size() - 1).put("last", true);
        context.put("scopes", scopesContext);

        return context;
    }
}
