package dev.dexuby.openaiclient.run.step;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Constants;

import java.lang.reflect.Type;

public class StepDetailsJsonSerializer implements JsonDeserializer<StepDetails> {

    @Override
    public StepDetails deserialize(@NotNull final JsonElement jsonElement, @NotNull final Type type, @NotNull final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final String stepDetailsType = jsonElement.getAsJsonObject().get("type").getAsString();
        switch (stepDetailsType) {
            case "message_creation" -> {
                return Constants.GSON.fromJson(jsonElement, MessageCreationStepDetails.class);
            }
            case "tool_calls" -> {
                return Constants.GSON.fromJson(jsonElement, ToolCallsStepDetails.class);
            }
            default -> {
                Constants.LOGGER.warn("Unknown step details type: " + stepDetailsType);
                return null;
            }
        }

    }

}
