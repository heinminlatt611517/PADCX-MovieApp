package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.google.gson.annotations.SerializedName

data class NowPlayingMovieResponse(
    @SerializedName("results")
    var retult : ArrayList<NowPlayingMovieVO> = arrayListOf()
)
