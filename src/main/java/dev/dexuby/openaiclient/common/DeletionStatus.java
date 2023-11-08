package dev.dexuby.openaiclient.common;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public record DeletionStatus(@NotNull String id,
                             @NotNull String object,
                             boolean deleted) {
}
