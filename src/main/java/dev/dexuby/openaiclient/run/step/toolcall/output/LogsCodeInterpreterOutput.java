package dev.dexuby.openaiclient.run.step.toolcall.output;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public class LogsCodeInterpreterOutput extends CodeInterpreterOutput {

    private final String logs;

    public LogsCodeInterpreterOutput(@NotNull final String type,
                                     @NotNull final String logs) {

        super(type);

        this.logs = logs;

    }

    public String getLogs() {

        return this.logs;

    }

}
