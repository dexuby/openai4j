package dev.dexuby.openaiclient.run.step.toolcall;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

import java.util.Map;

public class RetrievalToolCall extends ToolCall {

    private final Map<String, String> retrieval;

    public RetrievalToolCall(@NotNull final String id,
                             @NotNull final String type,
                             @NotNull final Map<String, String> retrieval) {

        super(id, type);

        this.retrieval = retrieval;

    }

    public Map<String, String> getRetrieval() {

        return this.retrieval;

    }

}
