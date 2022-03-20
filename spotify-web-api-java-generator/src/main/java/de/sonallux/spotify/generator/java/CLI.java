package de.sonallux.spotify.generator.java;

import de.sonallux.spotify.generator.java.util.JavaPackage;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.IVersionProvider;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.stream.Stream;

@Command(versionProvider = CLI.ManifestVersionProvider.class)
public class CLI implements Runnable {

    @Option(names = {"-f", "--file"}, description = "The OpenAPI definition to a generate a Java wrapper for")
    Path openApiFile;

    @Option(names = {"-o", "--output"}, required = true, description = "The folder to output the generated files to")
    Path outputFolder;

    @Option(names = {"--clean"}, description = "Deletes all content from the output folder")
    boolean shouldClean = false;

    @Option(names = {"-p", "--package"}, required = true, description = "The Java package name")
    String packageName = null;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Print usage help")
    boolean helpRequested = false;

    @Option(names = { "-v", "--version"}, versionHelp = true, description = "Print version information")
    boolean versionRequested = false;

    @Override
    public void run() {
        try {
            if (hasFiles(outputFolder)) {
                if (shouldClean) {
                    deleteDirectory(outputFolder);
                } else {
                    System.err.println("Warning: output folder is not empty. Existing files will be overridden.");
                }
            }

            var javaPackage = JavaPackage.fromPackage(packageName);

            var openApiAsString = Files.readString(openApiFile);
            var parseOptions = new ParseOptions();
            parseOptions.setResolve(false);
            parseOptions.setResolveFully(false);
            parseOptions.setResolveCombinators(false);
            var parseResult = new OpenAPIV3Parser().readContents(openApiAsString, null, parseOptions);
            if (!parseResult.getMessages().isEmpty()) {
                parseResult.getMessages().forEach(System.err::println);
                System.exit(1);
            }

            new JavaGenerator().generate(parseResult.getOpenAPI(), outputFolder, javaPackage);
        } catch (IOException e) {
            System.err.println("Failed to write generated files: " + e.getMessage());
            System.exit(1);
        } catch (GeneratorException e) {
            System.err.println("Failed to generate Java wrapper: " + e.getMessage());
            System.exit(1);
        }
    }

    private static boolean hasFiles(Path dir) throws IOException {
        return Files.exists(dir) && Files.list(dir).findAny().isPresent();
    }

    private static void deleteDirectory(Path dir) throws IOException {
        try (Stream<Path> walk = Files.walk(dir)) {
            walk.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    public static void main(String[] args) {
        var exitCode = new CommandLine(new CLI()).execute(args);
        System.exit(exitCode);
    }

    static class ManifestVersionProvider implements IVersionProvider {
        private static final String IMPLEMENTATION_TITLE = "spotify-web-api-java-generator";

        @Override
        public String[] getVersion() throws Exception {
            var resources = CLI.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                var url = resources.nextElement();
                try {
                    var manifest = new Manifest(url.openStream());
                    var attributes = manifest.getMainAttributes();
                    var title = get(attributes, "Implementation-Title");
                    if (IMPLEMENTATION_TITLE.equals(title)) {
                        var version = get(attributes, "Implementation-Version");
                        return new String[] { title + " version \"" + version + "\"" };
                    }
                } catch (IOException e) {
                    return new String[] { "Unable to read manifest from " + url + ": " + e };
                }
            }
            return new String[] { IMPLEMENTATION_TITLE + " version \"unknown\"" };
        }

        private static Object get(Attributes attributes, String key) {
            return attributes.get(new Attributes.Name(key));
        }
    }
}
