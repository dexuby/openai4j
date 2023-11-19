package dev.dexuby.openaiclient.image;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public record Image(@SerializedName("b64_json") @NotNull String b64Json,
                    @NotNull String url,
                    @SerializedName("revised_prompt") @NotNull String revisedPrompt) {
}
