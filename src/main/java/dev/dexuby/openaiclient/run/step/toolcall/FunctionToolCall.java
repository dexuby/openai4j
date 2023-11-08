package dev.dexuby.openaiclient.run.step.toolcall;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.run.ToolCallFunction;

public class FunctionToolCall extends ToolCall {

    private final ToolCallFunction function;

    public FunctionToolCall(@NotNull final String id,
                            @NotNull final String type,
                            @NotNull final ToolCallFunction function) {

        super(id, type);

        this.function = function;

    }

    public ToolCallFunction getFunction() {

        return this.function;

    }

}
