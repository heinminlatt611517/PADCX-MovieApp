package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.PopularMovieVO
import com.example.padcx_movieapp_assignment.data.vos.TopRateVO
import com.google.gson.annotations.SerializedName

data class TopRateMovieResponse (
    @SerializedName("page")
    var page : Int = 0,
    @SerializedName("results")
    var results : ArrayList<TopRateVO> = arrayListOf()
)
