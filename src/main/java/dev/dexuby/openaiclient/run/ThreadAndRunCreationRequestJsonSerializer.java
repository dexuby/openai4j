package dev.dexuby.openaiclient.run;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

public class ThreadAndRunCreationRequestJsonSerializer implements JsonSerializer<ThreadAndRunCreationRequest> {

    @Override
    public JsonElement serialize(@NotNull final ThreadAndRunCreationRequest request, @NotNull final Type type, @NotNull final JsonSerializationContext jsonSerializationContext) {

        final JsonElement jsonElement = jsonSerializationContext.serialize(request.getRunCreationRequest());
        jsonElement.getAsJsonObject().add("thread", jsonSerializationContext.serialize(request.getThreadCreationRequest()));

        return jsonElement;

    }

}
