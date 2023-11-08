package dev.dexuby.openaiclient.run.step;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class MessageCreationStepDetails extends StepDetails {

    @SerializedName("message_creation")
    private final MessageCreation messageCreation;

    public MessageCreationStepDetails(@NotNull final String type,
                                      @NotNull final MessageCreation messageCreation) {

        super(type);

        this.messageCreation = messageCreation;

    }

    public MessageCreation getMessageCreation() {

        return this.messageCreation;

    }

    public record MessageCreation(@SerializedName("message_id") @NotNull String messageId) {

    }

}
