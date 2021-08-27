package com.msp.restapi.postman

import com.google.gson.annotations.SerializedName


data class PMUser(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lname")
    val lname: String
)