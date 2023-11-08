package dev.dexuby.openaiclient.run.step;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public abstract class StepDetails {

    protected final String type;

    public StepDetails(@NotNull final String type) {

        this.type = type;

    }

    public String getType() {

        return this.type;

    }

}
