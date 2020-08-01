package com.example.padcx_movieapp_assignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padcx_movieapp_assignment.presistence.typeConverters.GenreTypeConverter
import com.google.gson.annotations.SerializedName
@Entity(tableName = "topRate")
@TypeConverters(GenreTypeConverter::class)
data class TopRateVO (
    @PrimaryKey
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("poster_path")
    var posterPath : String? = "",
    @SerializedName("adult")
    var adult: Boolean =false,
    @SerializedName("overview")
    var overView : String = "",
    @SerializedName("release_date")
    var releaseData : String = "",
    @SerializedName("genre_ids")
    var genreIds : ArrayList<Int> = arrayListOf(),
    @SerializedName("original_language")
    var originalLanguage : String="",
    @SerializedName("original_title")
    var originalTitle : String="",
    @SerializedName("title")
    var title : String = "",
    @SerializedName("backdrop_path")
    var backdropPath : String? = "",
    @SerializedName("popularity")
    var popularity : String = "",
    @SerializedName("video")
    var video : Boolean = false,
    @SerializedName("vote_average")
    var voteAverage : String= "",
    @SerializedName("vote_count")
    var voteCount : String = ""


)
