package com.msp.restapi.restgo

import com.google.gson.annotations.SerializedName

data class RGUserList(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta
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

    data class Meta(
        @SerializedName("pagination")
        val pagination: Pagination
    ) {
        data class Pagination(
            @SerializedName("limit")
            val limit: Int,
            @SerializedName("links")
            val links: Links,
            @SerializedName("page")
            val page: Int,
            @SerializedName("pages")
            val pages: Int,
            @SerializedName("total")
            val total: Int
        ) {
            data class Links(
                @SerializedName("current")
                val current: String,
                @SerializedName("next")
                val next: String,
                @SerializedName("previous")
                val previous: String
            )
        }
    }
}
