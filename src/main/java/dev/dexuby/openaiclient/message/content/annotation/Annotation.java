package dev.dexuby.openaiclient.message.content.annotation;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class Annotation {

    private final String type;
    private final String text;
    @SerializedName("start_index")
    private final int startIndex;
    @SerializedName("end_index")
    private final int endIndex;

    public Annotation(@NotNull final String type,
                      @NotNull final String text,
                      final int startIndex,
                      final int endIndex) {

        this.type = type;
        this.text = text;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    public String getType() {

        return this.type;

    }

    public String getText() {

        return this.text;

    }

    public int getStartIndex() {

        return this.startIndex;

    }

    public int getEndIndex() {

        return this.endIndex;

    }

}
