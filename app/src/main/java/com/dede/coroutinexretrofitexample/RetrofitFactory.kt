package com.dede.coroutinexretrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

    fun makeRetrofitService(): Service {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Service::class.java)
    }
}