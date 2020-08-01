package com.example.padcx_movieapp_assignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.padcx_movieapp_assignment.presistence.typeConverters.GenreTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular")
@TypeConverters(GenreTypeConverter::class)
data class PopularMovieVO (
    @PrimaryKey
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("popularity")
    var popularity : String = "",
    @SerializedName("vote_count")
    var voteCount : Int = 0,
    @SerializedName("video")
    var video : Boolean = false,
    @SerializedName("poster_path")
    var posterPath : String = "",
    @SerializedName("adult")
    var adult : Boolean= false,
    @SerializedName("backdrop_path")
    var backdropPath : String = "",
    @SerializedName("original_language")
    var originalLanguage : String= "",
    @SerializedName("original_title")
    var originalTitle : String= "",
    @SerializedName("genre_ids")
    var genreIDs : ArrayList<Int> = arrayListOf(),
    @SerializedName("title")
    var title : String = "",
    @SerializedName("vote_average")
    var voteAverage : Float= 0.0F,
    @SerializedName("overview")
    var overview : String = "",
    @SerializedName("release_date")
    var releaseDate : String = ""
)
