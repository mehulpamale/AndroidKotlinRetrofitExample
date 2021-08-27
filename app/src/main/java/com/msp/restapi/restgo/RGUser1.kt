package com.msp.restapi.restgo

import com.google.gson.annotations.SerializedName

data class RGUser1(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("meta")
    val meta: Any
) {
    data class Data(
        @SerializedName("email")
        val email: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("status")
        val status: String
    )
}
