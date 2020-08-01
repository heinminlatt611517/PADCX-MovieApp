package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("page")
    var page : Int = 0,
    @SerializedName("total_results")
    var totalResult : Int = 0,
    @SerializedName("total_pages")
    var totalPage : Int = 0,
    @SerializedName("results")
    var results : ArrayList<PopularMovieVO> = arrayListOf()
)
