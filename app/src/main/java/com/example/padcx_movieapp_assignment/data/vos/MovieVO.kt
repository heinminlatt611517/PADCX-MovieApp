package com.example.padcx_movieapp_assignment.data.vos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Multipart

data class MovieVO(

    @SerializedName("adult")
    var adult : Boolean = false,
    @SerializedName("backdrop_path")
    var backdropPath : String = "",
    @SerializedName("belongs_to_collection")
    var belongsToCollection : String = "",
    @SerializedName("budget")
    var budget : Int = 0,
    @SerializedName("genres")
    var genres : ArrayList<GenresVO> = arrayListOf(),
    @SerializedName("homepage")
    var homepage : String = "",
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("imdb_id")
    var imdbId : String = "",
    @SerializedName("original_language")
    var originalLanguage : String = "",
    @SerializedName("original_title")
    var originalTitle : String = "",
    @SerializedName("overview")
    var overview : String = "",
    @SerializedName("popularity")
    var popularity : String = "",
    @SerializedName("poster_path")
    var posterPath : String = "",
    @SerializedName("production_companies")
    var productionCompanies : ArrayList<ProductionCompanyVO> = arrayListOf(),
    @SerializedName("production_countries")
    var productionCountries : ArrayList<ProductionCountryVO> = arrayListOf(),
    @SerializedName("release_date")
    var releaseDate : String = "",
    @SerializedName("revenue")
    var revenue : Int = 0,
    @SerializedName("runtime")
    var runtime : Int = 0,
    @SerializedName("spoken_languages")
    var spokenLanguages : ArrayList<SpokenLanguageVO> = arrayListOf(),
    @SerializedName("status")
    var status : String = "",
    @SerializedName("tagline")
    var tagline : String = "",
    @SerializedName("title")
    var title : String = "",
    @SerializedName("video")
    var video : Boolean = false,
    @SerializedName("vote_average")
    var vote_average : Float = 0.0F,
    @SerializedName("vote_count")
    var vote_count : Int = 0


)


