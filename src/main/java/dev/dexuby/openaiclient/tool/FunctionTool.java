package dev.dexuby.openaiclient.tool;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class FunctionTool extends Tool {

    private final ToolFunction function;

    public FunctionTool(@NotNull final ToolType type,
                        @NotNull final ToolFunction function) {

        super(type);

        this.function = function;

    }

    public ToolFunction getFunction() {

        return this.function;

    }

}
