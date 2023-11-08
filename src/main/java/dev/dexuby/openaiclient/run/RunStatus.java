package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;

public enum RunStatus {

    @SerializedName("queued")
    QUEUED,
    @SerializedName("in_progress")
    IN_PROGRESS,
    @SerializedName("completed")
    COMPLETED,
    @SerializedName("requires_action")
    REQUIRES_ACTION,
    @SerializedName("expired")
    EXPIRED,
    @SerializedName("cancelling")
    CANCELLING,
    @SerializedName("cancelled")
    CANCELLED,
    @SerializedName("failed")
    FAILED

}
