package com.example.padcx_movieapp_assignment.network.response

import com.example.padcx_movieapp_assignment.data.vos.GenresVO
import com.google.gson.annotations.SerializedName

data class GenreMovieResponse(
    @SerializedName("genres")
    var genres : ArrayList<GenresVO> = arrayListOf()
)
