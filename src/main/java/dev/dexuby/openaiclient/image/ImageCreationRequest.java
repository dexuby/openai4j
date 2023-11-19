package dev.dexuby.openaiclient.image;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.common.Request;

public class ImageCreationRequest implements Request {

    private final String prompt;
    private final ImageModel model;
    @SerializedName("n")
    private final Integer count;
    private final ImageQuality quality;
    @SerializedName("response_format")
    private final ImageResponseFormat responseFormat;
    private final ImageSize size;
    private final ImageStyle style;
    private final String user;

    private ImageCreationRequest(@NotNull final Builder builder) {

        this.prompt = builder.prompt;
        this.model = builder.model;
        this.count = builder.count;
        this.quality = builder.quality;
        this.responseFormat = builder.responseFormat;
        this.size = builder.size;
        this.style = builder.style;
        this.user = builder.user;

    }

    @NotNull
    public String getPrompt() {

        return this.prompt;

    }

    @Nullable
    public ImageModel getModel() {

        return this.model;

    }

    @Nullable
    public int getCount() {

        return this.count;

    }

    @Nullable
    public ImageQuality getQuality() {

        return this.quality;

    }

    @Nullable
    public ImageResponseFormat getResponseFormat() {

        return this.responseFormat;

    }

    @Nullable
    public ImageSize getSize() {

        return this.size;

    }

    @Nullable
    public ImageStyle getStyle() {

        return this.style;

    }

    @Nullable
    public String getUser() {

        return this.user;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<ImageCreationRequest> {

        private String prompt;
        private ImageModel model;
        private Integer count;
        private ImageQuality quality;
        private ImageResponseFormat responseFormat;
        private ImageSize size;
        private ImageStyle style;
        private String user;

        public Builder prompt(@NotNull final String prompt) {

            this.prompt = prompt;
            return this;

        }

        public Builder model(@NotNull final ImageModel model) {

            this.model = model;
            return this;

        }

        public Builder count(final int count) {

            this.count = count;
            return this;

        }

        public Builder quality(@NotNull final ImageQuality quality) {

            this.quality = quality;
            return this;

        }

        public Builder responseFormat(@NotNull final ImageResponseFormat responseFormat) {

            this.responseFormat = responseFormat;
            return this;

        }

        public Builder size(@NotNull final ImageSize size) {

            this.size = size;
            return this;

        }

        public Builder style(@NotNull final ImageStyle style) {

            this.style = style;
            return this;

        }

        public Builder user(@NotNull final String user) {

            this.user = user;
            return this;

        }

        @NotNull
        @Override
        public ImageCreationRequest build() {

            Preconditions.checkNotNull(this.prompt);

            return new ImageCreationRequest(this);

        }

    }

}
