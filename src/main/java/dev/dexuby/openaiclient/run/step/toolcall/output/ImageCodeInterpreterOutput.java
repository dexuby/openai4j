package dev.dexuby.openaiclient.run.step.toolcall.output;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class ImageCodeInterpreterOutput extends CodeInterpreterOutput {

    private final Image image;

    public ImageCodeInterpreterOutput(@NotNull final String type,
                                      @NotNull final Image image) {

        super(type);

        this.image = image;

    }

    public Image getImage() {

        return this.image;

    }

    public record Image(@SerializedName("file_id") @NotNull String fileId) {

    }

}
