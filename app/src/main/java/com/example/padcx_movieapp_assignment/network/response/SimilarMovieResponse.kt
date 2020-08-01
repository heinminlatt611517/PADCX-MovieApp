package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.example.padcx_movieapp_assignment.data.vos.TopRateVO
import com.google.gson.annotations.SerializedName

data class SimilarMovieResponse(
    @SerializedName("page")
    var page : Int = 0,
    @SerializedName("results")
    var results : ArrayList<SimilarMovieVO> = arrayListOf()
)
