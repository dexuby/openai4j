package dev.dexuby.openaiclient.run.step.toolcall;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Constants;

import java.lang.reflect.Type;

public class ToolCallJsonSerializer implements JsonDeserializer<ToolCall> {

    @Override
    public ToolCall deserialize(@NotNull final JsonElement jsonElement, @NotNull final Type type, @NotNull final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final String toolCallType = jsonElement.getAsJsonObject().get("type").getAsString();
        switch (toolCallType) {
            case "code_interpreter" -> {
                return Constants.GSON.fromJson(jsonElement, CodeInterpreterToolCall.class);
            }
            case "retrieval" -> {
                return Constants.GSON.fromJson(jsonElement, RetrievalToolCall.class);
            }
            case "function" -> {
                return Constants.GSON.fromJson(jsonElement, FunctionToolCall.class);
            }
            default -> {
                Constants.LOGGER.warn("Unknown tool call type: " + toolCallType);
                return null;
            }
        }

    }

}
