package dev.dexuby.openaiclient.message;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.common.Role;

import java.util.List;
import java.util.Map;

public class MessageCreationRequest implements Request {

    private final Role role;
    private final String content;
    @SerializedName("file_ids")
    private final List<String> fileIds;
    private final Map<String, String> metadata;

    private MessageCreationRequest(@NotNull final Builder builder) {

        this.role = builder.role;
        this.content = builder.content;
        this.fileIds = builder.fileIds;
        this.metadata = builder.metadata;

    }

    public Role getRole() {

        return this.role;

    }

    public String getContent() {

        return this.content;

    }

    public List<String> getFileIds() {

        return this.fileIds;

    }

    public Map<String, String> getMetadata() {

        return this.metadata;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<MessageCreationRequest> {

        private Role role;
        private String content;
        private List<String> fileIds;
        private Map<String, String> metadata;

        public Builder role(@NotNull final Role role) {

            this.role = role;
            return this;

        }

        public Builder content(@NotNull final String content) {

            this.content = content;
            return this;

        }

        public Builder fileIds(@NotNull final List<String> fileIds) {

            this.fileIds = fileIds;
            return this;

        }

        public Builder metadata(@NotNull final Map<String, String> metadata) {

            this.metadata = metadata;
            return this;

        }

        @NotNull
        @Override
        public MessageCreationRequest build() {

            Preconditions.checkNotNull(this.role);
            Preconditions.checkNotNull(this.content);

            return new MessageCreationRequest(this);

        }

    }

}
