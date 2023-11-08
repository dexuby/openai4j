package dev.dexuby.openaiclient.run.step;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.run.step.toolcall.ToolCall;

import java.util.List;

public class ToolCallsStepDetails extends StepDetails {

    @SerializedName("tool_calls")
    private final List<ToolCall> toolCalls;

    public ToolCallsStepDetails(@NotNull final String type,
                                @NotNull final List<ToolCall> toolCalls) {

        super(type);

        this.toolCalls = toolCalls;

    }

    public List<ToolCall> getToolCalls() {

        return this.toolCalls;

    }

}
