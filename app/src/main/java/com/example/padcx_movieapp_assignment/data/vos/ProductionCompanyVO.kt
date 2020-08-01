package com.example.padcx_movieapp_assignment.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionCompanyVO(
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("logo_path")
    var logoPath : String = "",
    @SerializedName("name")
    var name : String = "",
    @SerializedName("origin_country")
    var origin_country : String = ""
)
