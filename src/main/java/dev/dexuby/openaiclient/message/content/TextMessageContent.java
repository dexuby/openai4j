package dev.dexuby.openaiclient.message.content;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.message.content.annotation.Annotation;

import java.util.List;

public class TextMessageContent extends MessageContent {

    private final Text text;

    public TextMessageContent(@NotNull final String type,
                              @NotNull final Text text) {

        super(type);

        this.text = text;

    }

    public Text getText() {

        return this.text;

    }

    public record Text(@NotNull String value,
                       @NotNull List<Annotation> annotations) {

    }

}
