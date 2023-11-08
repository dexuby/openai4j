package dev.dexuby.openaiclient.tool;

import com.google.gson.JsonObject;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public record ToolFunction(@NotNull String description,
                           @NotNull String name,
                           @NotNull JsonObject parameters) {

}
