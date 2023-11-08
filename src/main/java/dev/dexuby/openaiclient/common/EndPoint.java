package dev.dexuby.openaiclient.common;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public final class EndPoint {

    public static final String ASSISTANTS = "https://api.openai.com/v1/assistants";
    public static final String THREADS = "https://api.openai.com/v1/threads";

    public static String combine(@NotNull final String... input) {

        return String.join("/", input);

    }

}
