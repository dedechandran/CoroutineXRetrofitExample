package com.dede.coroutinexretrofitexample

import com.google.gson.annotations.SerializedName


data class SportResponse(
    @SerializedName("sports")
    val data: List<SportData>
) {
    data class SportData(
        @SerializedName("idSport")
        val sportId: String,

        @SerializedName("strSport")
        val sportName: String
    )
}
