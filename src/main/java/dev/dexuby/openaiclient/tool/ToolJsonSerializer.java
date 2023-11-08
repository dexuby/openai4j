package dev.dexuby.openaiclient.tool;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Constants;

import java.lang.reflect.Type;

public class ToolJsonSerializer implements JsonDeserializer<Tool> {

    @Override
    public Tool deserialize(@NotNull final JsonElement jsonElement, @NotNull final Type type, @NotNull final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final String toolType = jsonElement.getAsJsonObject().get("type").getAsString();
        switch (toolType) {
            case "code_interpreter" -> {
                return Constants.GSON.fromJson(jsonElement, CodeInterpreterTool.class);
            }
            case "retrieval" -> {
                return Constants.GSON.fromJson(jsonElement, RetrievalTool.class);
            }
            case "function" -> {
                return Constants.GSON.fromJson(jsonElement, FunctionTool.class);
            }
            default -> {
                Constants.LOGGER.warn("Unknown tool type: " + toolType);
                return null;
            }
        }

    }

}
