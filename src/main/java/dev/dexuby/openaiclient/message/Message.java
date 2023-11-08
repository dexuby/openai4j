package dev.dexuby.openaiclient.message;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.message.content.MessageContent;

import java.util.List;
import java.util.Map;

public record Message(@NotNull String id,
                      @NotNull String object,
                      @SerializedName("created_at") long createdAt,
                      @SerializedName("thread_id") @NotNull String threadId,
                      @NotNull String role,
                      @NotNull List<MessageContent> content,
                      @SerializedName("assistant_id") @Nullable String assistantId,
                      @SerializedName("run_id") @Nullable String runId,
                      @SerializedName("file_ids") @NotNull List<String> fileIds,
                      @NotNull Map<String, String> metadata) {
}
