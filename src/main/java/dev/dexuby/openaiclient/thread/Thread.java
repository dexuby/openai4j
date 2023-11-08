package dev.dexuby.openaiclient.thread;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

import java.util.Map;

public record Thread(@NotNull String id,
                     @NotNull String object,
                     @SerializedName("created_at") long createdAt,
                     @NotNull Map<String, String> metadata) {
}
