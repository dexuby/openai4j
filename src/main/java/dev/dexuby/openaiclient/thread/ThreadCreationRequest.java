package dev.dexuby.openaiclient.thread;

import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreadCreationRequest implements Request {

    private final List<Message> messages;
    private final Map<String, String> metadata;

    private ThreadCreationRequest(@NotNull final Builder builder) {

        this.messages = builder.messages;
        this.metadata = builder.metadata;

    }

    public List<Message> getMessages() {

        return this.messages;

    }

    public Map<String, String> getMetadata() {

        return this.metadata;

    }

    public static ThreadCreationRequest empty() {

        return new ThreadCreationRequest(new Builder());

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<ThreadCreationRequest> {

        private List<Message> messages;
        private Map<String, String> metadata;

        public Builder message(@NotNull final Message message) {

            if (messages == null)
                messages = new ArrayList<>();

            messages.add(message);
            return this;

        }

        public Builder messages(@NotNull final List<Message> messages) {

            this.messages = messages;
            return this;

        }

        public Builder metadata(@NotNull final Map<String, String> metadata) {

            this.metadata = metadata;
            return this;

        }

        @NotNull
        @Override
        public ThreadCreationRequest build() {

            return new ThreadCreationRequest(this);

        }

    }

}
