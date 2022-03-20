module de.sonallux.spotify.generator.java {
    requires com.google.common;
    requires flexmark;
    requires flexmark.util.ast;
    requires flexmark.util.data;
    requires info.picocli;
    requires org.slf4j;
    requires com.github.mustachejava;
    requires spotify.web.api.core;

    exports de.sonallux.spotify.generator.java;
    exports de.sonallux.spotify.generator.java.generators;
    exports de.sonallux.spotify.generator.java.util;
}
