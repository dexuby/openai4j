package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.tool.Tool;

import java.util.List;
import java.util.Map;

public record Run(@NotNull String id,
                  @NotNull String object,
                  @SerializedName("created_at") long createdAt,
                  @SerializedName("thread_id") @NotNull String threadId,
                  @SerializedName("assistant_id") @NotNull String assistantId,
                  @NotNull String status,
                  @SerializedName("required_action") @Nullable RequiredAction requiredAction,
                  @SerializedName("last_error") @Nullable Error lastError,
                  @SerializedName("expires_at") @Nullable Long expiresAt,
                  @SerializedName("started_at") @Nullable Long startedAt,
                  @SerializedName("cancelled_at") @Nullable Long cancelledAt,
                  @SerializedName("failed_at") @Nullable Long failedAt,
                  @SerializedName("completed_at") @Nullable Long completedAt,
                  @NotNull String model,
                  @NotNull String instructions,
                  @NotNull List<Tool> tools,
                  @SerializedName("file_ids") @NotNull List<String> fileIds,
                  @NotNull Map<String, String> metadata) {
}
