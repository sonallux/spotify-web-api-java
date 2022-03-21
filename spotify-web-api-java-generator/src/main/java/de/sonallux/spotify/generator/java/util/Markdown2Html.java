package de.sonallux.spotify.generator.java.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.IndependentLinkResolverFactory;
import com.vladsch.flexmark.html.LinkResolver;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Markdown2Html {
    private static final Parser PARSER;
    private static final HtmlRenderer HTML_RENDERER;

    static {
        var parserOptions = new MutableDataSet();
        PARSER = Parser.builder(parserOptions).build();

        var rendererOptions = new MutableDataSet();
        HTML_RENDERER = HtmlRenderer.builder(rendererOptions).linkResolverFactory(new IndependentLinkResolverFactory() {
            @Override
            public @NotNull LinkResolver apply(@NotNull LinkResolverBasicContext ctx) {
                return SPOTIFY_LINK_RESOLVER;
            }
        }).build();
    }

    private static final LinkResolver SPOTIFY_LINK_RESOLVER = (node, context, link) -> {
        if (link.getUrl().startsWith("/documentation/web-api")) {
            return link.withUrl("https://developer.spotify.com" + link.getUrl()).withStatus(LinkStatus.VALID);
        }
        if (link.getUrl().startsWith("http://")) {
            return link.withUrl("https" + link.getUrl().substring(4));
        }
        return link;
    };

    public static String convert(String markdown) {
        var document = PARSER.parse(markdown);
        var html = HTML_RENDERER.render(document);
        return html.replaceAll("<br />", "<br>");
    }

    public static String convertToSingleLine(String markdown) {
        return convert(markdown)
            .replaceAll(">\n", ">")
            .replaceAll("\n", " ")
            .trim();
    }

    public static List<String> convertToLines(String markdown) {
        var html = convert(markdown);
        return Arrays.stream(html.split("\n"))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
