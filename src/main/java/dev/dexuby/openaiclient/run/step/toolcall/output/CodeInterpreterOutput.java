package dev.dexuby.openaiclient.run.step.toolcall.output;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class CodeInterpreterOutput {

    protected final String type;

    public CodeInterpreterOutput(@NotNull final String type) {

        this.type = type;

    }

    public String getType() {

        return this.type;

    }

}
