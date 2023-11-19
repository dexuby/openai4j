package dev.dexuby.openaiclient.image;

import com.google.gson.annotations.SerializedName;

public enum ImageResponseFormat {

    @SerializedName("url")
    URL,
    @SerializedName("b64_json")
    B64_JSON

}
