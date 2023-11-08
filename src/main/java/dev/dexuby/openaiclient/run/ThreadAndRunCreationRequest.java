package dev.dexuby.openaiclient.run;

import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.thread.ThreadCreationRequest;

public class ThreadAndRunCreationRequest implements Request {

    private final RunCreationRequest runCreationRequest;
    private final ThreadCreationRequest threadCreationRequest;

    private ThreadAndRunCreationRequest(@NotNull final Builder builder) {

        this.runCreationRequest = builder.runCreationRequest;
        this.threadCreationRequest = builder.threadCreationRequest;

    }

    @NotNull
    public RunCreationRequest getRunCreationRequest() {

        return this.runCreationRequest;

    }

    @Nullable
    public ThreadCreationRequest getThreadCreationRequest() {

        return this.threadCreationRequest;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<ThreadAndRunCreationRequest> {

        private RunCreationRequest runCreationRequest;
        private ThreadCreationRequest threadCreationRequest;

        public Builder runCreationRequest(@NotNull final RunCreationRequest runCreationRequest) {

            this.runCreationRequest = runCreationRequest;
            return this;

        }

        public Builder threadCreationRequest(@NotNull final ThreadCreationRequest threadCreationRequest) {

            this.threadCreationRequest = threadCreationRequest;
            return this;

        }

        @NotNull
        @Override
        public ThreadAndRunCreationRequest build() {

            Preconditions.checkNotNull(runCreationRequest);

            return new ThreadAndRunCreationRequest(this);

        }

    }

}
