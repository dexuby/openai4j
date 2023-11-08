package dev.dexuby.openaiclient.message.content;

import com.google.gson.*;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Constants;

import java.lang.reflect.Type;

public class MessageContentJsonSerializer implements JsonDeserializer<MessageContent> {

    @Override
    public MessageContent deserialize(@NotNull final JsonElement jsonElement, @NotNull final Type type, @NotNull final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final String messageContentType = jsonElement.getAsJsonObject().get("type").getAsString();
        switch (messageContentType) {
            case "image_file" -> {
                return Constants.GSON.fromJson(jsonElement, ImageMessageContent.class);
            }
            case "text" -> {
                return Constants.GSON.fromJson(jsonElement, TextMessageContent.class);
            }
            default -> {
                Constants.LOGGER.warn("Unknown message content type: " + messageContentType);
                return null;
            }
        }

    }

}
