package dev.dexuby.openaiclient.run;

import dev.dexuby.easycommon.builder.FluentBuilder;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.common.Query;

import java.util.HashMap;
import java.util.Map;

public class RunListQuery extends Query {

    private RunListQuery(@NotNull final Builder builder) {

        super(builder.entries);

    }

    public static RunListQuery empty() {

        return new RunListQuery(new Builder());

    }

    public static Builder builder() {

        return new Builder();

    }

    public static class Builder implements FluentBuilder<RunListQuery> {

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
        public RunListQuery build() {

            return new RunListQuery(this);

        }

    }

}
