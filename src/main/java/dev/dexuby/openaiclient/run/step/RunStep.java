package dev.dexuby.openaiclient.run.step;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.run.Error;

import java.util.List;
import java.util.Map;

public record RunStep(@NotNull String id,
                      @NotNull String object,
                      @SerializedName("created_at") long createdAt,
                      @SerializedName("assistant_id") @NotNull String assistantId,
                      @SerializedName("thread_id") @NotNull String threadId,
                      @SerializedName("run_id") @NotNull String runId,
                      @NotNull String type,
                      @NotNull String status,
                      @SerializedName("step_details") @NotNull List<StepDetails> stepDetails,
                      @SerializedName("last_error") @Nullable Error lastError,
                      @SerializedName("expired_at") @Nullable Long expiredAt,
                      @SerializedName("cancelled_at") @Nullable Long cancelledAt,
                      @SerializedName("failed_at") @Nullable Long failedAt,
                      @SerializedName("completed_at") @Nullable Long completedAt,
                      @NotNull Map<String, String> metadata) {
}
