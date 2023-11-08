package dev.dexuby.openaiclient.run;

import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.common.Request;

import java.util.Map;

public class RunModificationRequest implements Request {

    private final Map<String, String> metadata;

    private RunModificationRequest(@NotNull final Builder builder) {

        this.metadata = builder.metadata;

    }

    @Nullable
    public Map<String, String> getMetadata() {

        return this.metadata;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<RunModificationRequest> {

        private Map<String, String> metadata;

        public Builder metadata(@NotNull final Map<String, String> metadata) {

            this.metadata = metadata;
            return this;

        }

        @NotNull
        @Override
        public RunModificationRequest build() {

            return new RunModificationRequest(this);

        }

    }

}
