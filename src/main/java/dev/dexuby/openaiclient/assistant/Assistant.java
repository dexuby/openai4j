package dev.dexuby.openaiclient.assistant;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.tool.Tool;

import java.util.List;
import java.util.Map;

public record Assistant(@NotNull String id,
                        @NotNull String object,
                        @SerializedName("created_at") long createdAt,
                        @Nullable String name,
                        @Nullable String description,
                        @NotNull String model,
                        @Nullable String instructions,
                        @NotNull List<Tool> tools,
                        @SerializedName("file_ids") @NotNull List<String> fileIds,
                        @NotNull Map<String, String> metadata) {
}
