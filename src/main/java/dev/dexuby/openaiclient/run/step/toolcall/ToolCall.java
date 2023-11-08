package dev.dexuby.openaiclient.run.step.toolcall;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class ToolCall {

    protected final String id;
    protected final String type;

    public ToolCall(@NotNull final String id,
                    @NotNull final String type) {

        this.id = id;
        this.type = type;

    }

    public String getId() {

        return this.id;

    }

    public String getType() {

        return this.type;

    }

}
