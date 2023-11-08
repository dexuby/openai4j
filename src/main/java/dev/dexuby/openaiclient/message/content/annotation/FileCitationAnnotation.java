package dev.dexuby.openaiclient.message.content.annotation;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class FileCitationAnnotation extends Annotation {

    @SerializedName("file_citation")
    private final FileCitation fileCitation;

    public FileCitationAnnotation(@NotNull final String type,
                                  @NotNull final String text,
                                  final int startIndex,
                                  final int endIndex,
                                  @NotNull final FileCitation fileCitation) {

        super(type, text, startIndex, endIndex);

        this.fileCitation = fileCitation;

    }

    public FileCitation getFileCitation() {

        return this.fileCitation;

    }

    public record FileCitation(@SerializedName("file_id") @NotNull String fileId,
                               @NotNull String quote) {

    }

}
