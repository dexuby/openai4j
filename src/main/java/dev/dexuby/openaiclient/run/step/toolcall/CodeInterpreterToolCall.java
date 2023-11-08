package dev.dexuby.openaiclient.run.step.toolcall;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.run.step.toolcall.output.CodeInterpreterOutput;

import java.util.List;

public class CodeInterpreterToolCall extends ToolCall {

    @SerializedName("code_interpreter")
    private final CodeInterpreter codeInterpreter;

    public CodeInterpreterToolCall(@NotNull final String id,
                                   @NotNull final String type,
                                   @NotNull final CodeInterpreter codeInterpreter) {

        super(id, type);

        this.codeInterpreter = codeInterpreter;

    }

    public CodeInterpreter getCodeInterpreter() {

        return this.codeInterpreter;

    }

    public record CodeInterpreter(@NotNull String input,
                                  @NotNull List<CodeInterpreterOutput> outputs) {

    }

}
