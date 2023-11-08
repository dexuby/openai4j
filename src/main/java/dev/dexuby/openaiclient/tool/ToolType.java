package dev.dexuby.openaiclient.tool;

import com.google.gson.annotations.SerializedName;

public enum ToolType {

    @SerializedName("code_interpreter")
    CODE_INTERPRETER,
    @SerializedName("retrieval")
    RETRIEVAL,
    @SerializedName("function")
    FUNCTION

}
