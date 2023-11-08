package dev.dexuby.openaiclient.assistant;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Model;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.tool.Tool;

import java.util.List;
import java.util.Map;

public class AssistantCreationRequest implements Request {

    private final Model model;
    private final String name;
    private final String description;
    private final String instructions;
    private final List<Tool> tools;
    @SerializedName("file_ids")
    private final List<String> fileIds;
    private final Map<String, String> metadata;

    private AssistantCreationRequest(@NotNull final Builder builder) {

        this.model = builder.model;
        this.name = builder.name;
        this.description = builder.description;
        this.instructions = builder.instructions;
        this.tools = builder.tools;
        this.fileIds = builder.fileIds;
        this.metadata = builder.metadata;

    }

    public Model getModel() {

        return this.model;

    }

    public String getName() {

        return this.name;

    }

    public String getDescription() {

        return this.description;

    }

    public String getInstructions() {

        return this.instructions;

    }

    public List<Tool> getTools() {

        return this.tools;

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

    public static class Builder implements FluentBuilder<AssistantCreationRequest> {

        private Model model;
        private String name;
        private String description;
        private String instructions;
        private List<Tool> tools;
        @SerializedName("file_ids")
        private List<String> fileIds;
        private Map<String, String> metadata;

        public Builder model(@NotNull final Model model) {

            this.model = model;
            return this;

        }

        public Builder name(@NotNull final String name) {

            this.name = name;
            return this;

        }

        public Builder description(@NotNull final String description) {

            this.description = description;
            return this;

        }

        public Builder instructions(@NotNull final String instructions) {

            this.instructions = instructions;
            return this;

        }

        public Builder tools(@NotNull final List<Tool> tools) {

            this.tools = tools;
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
        public AssistantCreationRequest build() {

            Preconditions.checkNotNull(this.model);

            return new AssistantCreationRequest(this);

        }

    }

}
