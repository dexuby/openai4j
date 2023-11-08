package dev.dexuby.openaiclient.message.content.annotation;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class FilePathAnnotation extends Annotation {

    @SerializedName("file_path")
    private final FilePath filePath;

    public FilePathAnnotation(@NotNull final String type,
                              @NotNull final String text,
                              final int startIndex,
                              final int endIndex,
                              @NotNull final FilePath filePath) {

        super(type, text, startIndex, endIndex);

        this.filePath = filePath;

    }

    public FilePath getFilePath() {

        return this.filePath;

    }

    public record FilePath(@SerializedName("file_id") @NotNull String fileId) {

    }

}
