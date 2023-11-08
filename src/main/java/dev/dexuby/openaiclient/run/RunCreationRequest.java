package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.easycommon.external.jetbrains.annotations.Nullable;
import dev.dexuby.openaiclient.common.Model;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.tool.Tool;

import java.util.List;
import java.util.Map;

public class RunCreationRequest implements Request {

    @SerializedName("assistant_id")
    private final String assistantId;
    private final Model model;
    private final String instructions;
    private final List<Tool> tools;
    private final Map<String, String> metadata;

    public RunCreationRequest(@NotNull final Builder builder) {

        this.assistantId = builder.assistantId;
        this.model = builder.model;
        this.instructions = builder.instructions;
        this.tools = builder.tools;
        this.metadata = builder.metadata;

    }

    @NotNull
    public String getAssistantId() {

        return this.assistantId;

    }

    @Nullable
    public Model getModel() {

        return this.model;

    }

    @Nullable
    public String getInstructions() {

        return this.instructions;

    }

    @Nullable
    public List<Tool> getTools() {

        return this.tools;

    }

    @Nullable
    public Map<String, String> getMetadata() {

        return this.metadata;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<RunCreationRequest> {

        private String assistantId;
        private Model model;
        private String instructions;
        private List<Tool> tools;
        private Map<String, String> metadata;

        public Builder assistantId(@NotNull final String assistantId) {

            this.assistantId = assistantId;
            return this;

        }

        public Builder model(@NotNull final Model model) {

            this.model = model;
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

        public Builder metadata(@NotNull final Map<String, String> metadata) {

            this.metadata = metadata;
            return this;

        }

        @NotNull
        @Override
        public RunCreationRequest build() {

            Preconditions.checkNotNull(this.assistantId);

            return new RunCreationRequest(this);

        }

    }

}
