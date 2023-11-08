package dev.dexuby.openaiclient.message.content;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class MessageContent {

    protected final String type;

    public MessageContent(@NotNull final String type) {

        this.type = type;

    }

    public String getType() {

        return this.type;

    }

}
