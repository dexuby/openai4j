package dev.dexuby.openaiclient.image;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

import java.util.List;

public record ImageList(long created,
                        @SerializedName("data") @NotNull List<Image> images) {
}
