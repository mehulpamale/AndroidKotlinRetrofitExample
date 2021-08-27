package com.msp.restapi.restgo

import retrofit2.Call
import retrofit2.http.GET

interface RGService {
    @GET("/public/v1/users/125")
    fun getUser(): Call<RGUser1>

    @GET("public/v1/users")
    fun getUsers(): Call<RGUserList>
}