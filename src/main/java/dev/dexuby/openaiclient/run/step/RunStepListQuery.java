package dev.dexuby.openaiclient.run.step;

import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Query;
import dev.dexuby.openaiclient.run.RunListQuery;

import java.util.HashMap;
import java.util.Map;

public class RunStepListQuery extends Query {

    private RunStepListQuery(@NotNull final Builder builder) {

        super(builder.entries);

    }

    public static RunStepListQuery empty() {

        return new RunStepListQuery(new Builder());

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<RunStepListQuery> {

        private final Map<String, String> entries = new HashMap<>();

        public Builder limit(final int limit) {

            this.entries.put("limit", String.valueOf(limit));
            return this;

        }

        public Builder order(@NotNull final String order) {

            this.entries.put("order", order);
            return this;

        }

        public Builder after(@NotNull final String after) {

            this.entries.put("after", after);
            return this;

        }

        public Builder before(@NotNull final String before) {

            this.entries.put("before", before);
            return this;

        }

        @NotNull
        @Override
        public RunStepListQuery build() {

            return new RunStepListQuery(this);

        }

    }

}
