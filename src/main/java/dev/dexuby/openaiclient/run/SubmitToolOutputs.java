package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.run.step.toolcall.FunctionToolCall;

import java.util.List;

/**
 * @see dev.dexuby.openaiclient.run.RequiredAction;
 */

public record SubmitToolOutputs(@SerializedName("tool_calls") @NotNull List<FunctionToolCall> toolCalls) {
}
