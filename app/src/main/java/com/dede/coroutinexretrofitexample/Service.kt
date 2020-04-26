package com.dede.coroutinexretrofitexample

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("all_sports.php")
    suspend fun getLeagues(): Response<SportResponse>
}