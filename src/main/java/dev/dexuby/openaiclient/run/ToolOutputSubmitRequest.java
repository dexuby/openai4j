package dev.dexuby.openaiclient.run;

import com.google.gson.annotations.SerializedName;
import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.conditional.Preconditions;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Request;

import java.util.ArrayList;
import java.util.List;

public class ToolOutputSubmitRequest implements Request {

    @SerializedName("tool_outputs")
    private final List<ToolOutput> toolOutputs;

    private ToolOutputSubmitRequest(@NotNull final Builder builder) {

        this.toolOutputs = builder.toolOutputs;

    }

    @NotNull
    public List<ToolOutput> getToolOutputs() {

        return this.toolOutputs;

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<ToolOutputSubmitRequest> {

        private List<ToolOutput> toolOutputs;

        public Builder toolOutput(@NotNull final ToolOutput toolOutput) {

            if (this.toolOutputs == null)
                this.toolOutputs = new ArrayList<>();

            this.toolOutputs.add(toolOutput);
            return this;

        }

        public Builder toolOutputs(@NotNull final List<ToolOutput> toolOutputs) {

            this.toolOutputs = toolOutputs;
            return this;

        }

        @NotNull
        @Override
        public ToolOutputSubmitRequest build() {

            Preconditions.checkNotNull(this.toolOutputs);

            return new ToolOutputSubmitRequest(this);

        }

    }

}
