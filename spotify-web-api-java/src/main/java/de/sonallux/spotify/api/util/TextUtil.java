package de.sonallux.spotify.api.util;

import org.jspecify.annotations.Nullable;

public final class TextUtil {
    private TextUtil() {}

    public static boolean hasText(@Nullable String str) {
        return str != null && !str.isEmpty();
    }
}
