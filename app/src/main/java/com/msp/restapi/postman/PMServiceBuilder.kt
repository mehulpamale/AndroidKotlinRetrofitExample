package com.msp.restapi.postman

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PMServiceBuilder {
    private const val URL = "https://d23aaa62-60f1-480b-962b-51e1d9b2294a.mock.pstmn.io/"

    private val okHttp = OkHttpClient.Builder()

    val gson = GsonBuilder().setLenient().create()

    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}