package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;

public record ToolOutput(@SerializedName("tool_call_id") @Nullable String toolCallId,
                         @Nullable String output) {
}
