package dev.dexuby.openaiclient.message.content;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class ImageMessageContent extends MessageContent {

    @SerializedName("image_file")
    private final ImageFile imageFile;

    public ImageMessageContent(@NotNull final String type,
                               @NotNull final ImageFile imageFile) {

        super(type);

        this.imageFile = imageFile;

    }

    public ImageFile getImageFile() {

        return this.imageFile;

    }

    public record ImageFile(@SerializedName("file_id") @NotNull String fileId) {

    }

}
