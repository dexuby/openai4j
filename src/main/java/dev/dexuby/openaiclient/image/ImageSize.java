package dev.dexuby.openaiclient.image;

import com.google.gson.annotations.SerializedName;

public enum ImageSize {

    @SerializedName("256x256")
    X_256_256,
    @SerializedName("512x512")
    X_512_512,
    @SerializedName("1024x1024")
    X_1024_1024,
    @SerializedName("1792x1024")
    X_1792_1024,
    @SerializedName("1024x1792")
    X_1024_1792

}
