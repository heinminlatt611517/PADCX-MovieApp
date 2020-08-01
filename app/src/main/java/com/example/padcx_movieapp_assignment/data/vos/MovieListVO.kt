package com.example.padcx_movieapp_assignment.data.vos

import com.google.gson.annotations.SerializedName

data class MovieListVO(
    @SerializedName("description")
    var description : String = "",
    @SerializedName("favorite_count")
    var favouriteCount : Int= 0,
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("item_count")
    var itemCount : Int= 0,
    @SerializedName("iso_639_1")
    var iso : String = "",
    @SerializedName("list_type")
    var listType : String= "",
    @SerializedName("name")
    var name : String = "",
    @SerializedName("poster_path")
    var posterPath : String?= ""

)
