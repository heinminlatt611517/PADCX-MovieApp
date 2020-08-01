package com.example.padcx_movieapp_assignment.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionCountryVO (
    @SerializedName("iso_3166_1")
    var iso : String = "",
    @SerializedName("name")
    var name : String = ""
)
