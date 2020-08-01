package com.example.padcx_movieapp_assignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.*
import com.example.padcx_movieapp_assignment.presistence.typeConverters.GenreTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "NowPlaying")
@TypeConverters(GenreTypeConverter::class)
data class NowPlayingMovieVO (
    @PrimaryKey
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("popularity")
    var popularity : String = "",
    @SerializedName("vote_count")
    var voteCount : String = "",
    @SerializedName("video")
    var video : Boolean = false,
    @SerializedName("poster_path")
    var posterPath : String = "",
    @SerializedName("adult")
    var adult : Boolean = false,
    @SerializedName("backdrop_path")
    var backdropPath : String = "",
    @SerializedName("original_language")
    var originalLanguage : String="",
    @SerializedName("original_title")
    var originalTitle : String="",
    @SerializedName("genre_ids")
    var genreIds : ArrayList<Int> = arrayListOf(),
    @SerializedName("title")
    var title : String = "",
    @SerializedName("vote_average")
    var voteAverage : String= "",
    @SerializedName("overview")
    var overView : String = "",
    @SerializedName("release_date")
    var releaseData : String = ""
)
