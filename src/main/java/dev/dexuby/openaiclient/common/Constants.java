package dev.dexuby.openaiclient.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.dexuby.openaiclient.message.content.MessageContent;
import dev.dexuby.openaiclient.message.content.MessageContentJsonSerializer;
import dev.dexuby.openaiclient.run.ThreadAndRunCreationRequest;
import dev.dexuby.openaiclient.run.ThreadAndRunCreationRequestJsonSerializer;
import dev.dexuby.openaiclient.run.step.StepDetails;
import dev.dexuby.openaiclient.run.step.StepDetailsJsonSerializer;
import dev.dexuby.openaiclient.run.step.toolcall.ToolCall;
import dev.dexuby.openaiclient.run.step.toolcall.ToolCallJsonSerializer;
import dev.dexuby.openaiclient.run.step.toolcall.output.CodeInterpreterOutput;
import dev.dexuby.openaiclient.run.step.toolcall.output.CodeInterpreterOutputJsonSerializer;
import dev.dexuby.openaiclient.tool.Tool;
import dev.dexuby.openaiclient.tool.ToolJsonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constants {

    public static final Logger LOGGER = LoggerFactory.getLogger("openai-client");

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(MessageContent.class, new MessageContentJsonSerializer())
            .registerTypeAdapter(StepDetails.class, new StepDetailsJsonSerializer())
            .registerTypeAdapter(CodeInterpreterOutput.class, new CodeInterpreterOutputJsonSerializer())
            .registerTypeAdapter(ToolCall.class, new ToolCallJsonSerializer())
            .registerTypeAdapter(Tool.class, new ToolJsonSerializer())
            .registerTypeAdapter(ThreadAndRunCreationRequest.class, new ThreadAndRunCreationRequestJsonSerializer())
            .create();

}
