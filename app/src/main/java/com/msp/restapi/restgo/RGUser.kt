package com.msp.restapi.restgo

import com.google.gson.annotations.SerializedName

data class RGUser(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("meta")
    val meta: Any
) {
    data class Data(
        @SerializedName("message")
        val message: String
    )
}

