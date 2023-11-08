package dev.dexuby.openaiclient.tool;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class Tool {

    private final ToolType type;

    protected Tool(@NotNull final ToolType type) {

        this.type = type;

    }

    public ToolType getType() {

        return this.type;

    }

}
