package dev.dexuby.openaiclient.tts;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Request;

public class TextToSpeechRequest implements Request {

    private final TextToSpeechModel model;
    private final TextToSpeechVoice voice;
    private final String input;
    @SerializedName("response_format")
    private final TextToSpeechFormat format;
    private final double speed;

    private TextToSpeechRequest(@NotNull final Builder builder) {

        this.model = builder.model;
        this.voice = builder.voice;
        this.input = builder.text;
        this.format = builder.format;
        this.speed = builder.speed;

    }

    public TextToSpeechModel getModel() {

        return this.model;

    }

    public TextToSpeechVoice getVoice() {

        return this.voice;

    }

    public String getInput() {

        return this.input;

    }

    public TextToSpeechFormat getFormat() {

        return this.format;

    }

    public double getSpeed() {

        return this.speed;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<TextToSpeechRequest> {

        private TextToSpeechModel model;
        private TextToSpeechVoice voice;
        private String text;
        private TextToSpeechFormat format = TextToSpeechFormat.MP3;
        private double speed = 1.0d;

        public Builder model(@NotNull final TextToSpeechModel model) {

            this.model = model;
            return this;

        }

        public Builder voice(@NotNull final TextToSpeechVoice voice) {

            this.voice = voice;
            return this;

        }

        public Builder text(@NotNull final String text) {

            this.text = text;
            return this;

        }

        public Builder format(@NotNull final TextToSpeechFormat format) {

            this.format = format;
            return this;

        }

        public Builder speed(final double speed) {

            this.speed = speed;
            return this;

        }

        @NotNull
        @Override
        public TextToSpeechRequest build() {

            Preconditions.checkNotNull(this.model);
            Preconditions.checkNotNull(this.voice);
            Preconditions.checkNotNull(this.text);

            return new TextToSpeechRequest(this);

        }

    }

}
