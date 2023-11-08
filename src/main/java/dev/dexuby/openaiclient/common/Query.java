package dev.dexuby.openaiclient.common;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

import java.util.Map;

public abstract class Query {

    protected final Map<String, String> entries;

    protected Query(@NotNull final Map<String, String> entries) {

        this.entries = entries;

    }

    public Map<String, String> getEntries() {

        return this.entries;

    }

    public String construct() {

        final StringBuilder stringBuilder = new StringBuilder();
        for (final Map.Entry<String, String> entry : this.entries.entrySet()) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append('?');
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
        }

        return stringBuilder.toString();

    }

}
