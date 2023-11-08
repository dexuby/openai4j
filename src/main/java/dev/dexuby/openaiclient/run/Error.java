package dev.dexuby.openaiclient.run;

import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;

public record Error(@NotNull String code,
                    @NotNull String message) {
}
