package com.msp.restapi.restgo

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RGServiceBuilder {
    private const val URL = "https://gorest.co.in/"

    private val okHttp = OkHttpClient.Builder()

    val gson = GsonBuilder().setPrettyPrinting().create()

    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}