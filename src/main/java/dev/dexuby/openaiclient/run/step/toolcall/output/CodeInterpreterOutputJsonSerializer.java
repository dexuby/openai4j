package dev.dexuby.openaiclient.run.step.toolcall.output;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Constants;

import java.lang.reflect.Type;

public class CodeInterpreterOutputJsonSerializer implements JsonDeserializer<CodeInterpreterOutput> {

    @Override
    public CodeInterpreterOutput deserialize(@NotNull final JsonElement jsonElement, @NotNull final Type type, @NotNull final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final String codeInterpreterOutputType = jsonElement.getAsJsonObject().get("type").getAsString();
        switch (codeInterpreterOutputType) {
            case "logs" -> {
                return Constants.GSON.fromJson(jsonElement, LogsCodeInterpreterOutput.class);
            }
            case "image" -> {
                return Constants.GSON.fromJson(jsonElement, ImageCodeInterpreterOutput.class);
            }
            default -> {
                Constants.LOGGER.warn("Unknown code interpreter output type: " + codeInterpreterOutputType);
                return null;
            }
        }

    }

}
