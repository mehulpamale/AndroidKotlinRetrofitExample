package com.msp.restapi.postman

import retrofit2.Call
import retrofit2.http.GET

interface PostmanService {
    @GET("/testuser")
    fun getUser(): Call<PMUser>
}