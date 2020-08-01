package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.google.gson.annotations.SerializedName

data class MovieListResponse (
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("page")
    var page : Int = 0,
    @SerializedName("results")
    var results : ArrayList<MovieListVO> = arrayListOf()
)
