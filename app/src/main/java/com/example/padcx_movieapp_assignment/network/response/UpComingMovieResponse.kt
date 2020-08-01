package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.UpcomingMovieVO
import com.google.gson.annotations.SerializedName

data class UpComingMovieResponse (
    @SerializedName("results")
    var retult : ArrayList<UpcomingMovieVO> = arrayListOf()
)