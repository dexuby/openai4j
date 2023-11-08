package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public record RequiredAction(@NotNull String type,
                             @SerializedName("submit_tool_outputs") @NotNull SubmitToolOutputs submitToolOutputs) {

}
