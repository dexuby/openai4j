package dev.dexuby.openaiclient.run;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;

public record ToolCallFunction(@NotNull String name,
                               @NotNull String arguments,
                               @Nullable String output) {

}
