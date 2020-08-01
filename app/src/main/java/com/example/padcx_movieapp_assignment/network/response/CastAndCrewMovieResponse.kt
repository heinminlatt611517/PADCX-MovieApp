package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.CastVO
import com.example.padcx_movieapp_assignment.data.vos.CrewVO
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.google.gson.annotations.SerializedName

data class CastAndCrewMovieResponse(
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("cast")
    var cast : ArrayList<CastVO> = arrayListOf(),
    @SerializedName("crew")
    var crew : ArrayList<CrewVO> = arrayListOf()

)
