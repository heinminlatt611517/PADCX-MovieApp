package com.example.padcx_movieapp_assignment.data.model

import androidx.lifecycle.LiveData
import com.example.padcx_movieapp_assignment.data.vos.*
import io.reactivex.Observable

interface MovieModel {

    fun firstTimeNowPlayingMovieSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun firstTimeUpComingMovieSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun firstTimePopularMovieSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun firstTimeTopRateMovieSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getAllNowPlayingMovie() : LiveData<List<NowPlayingMovieVO>>

    fun getMovieById(movieId : Int) : Observable<MovieVO>

    fun getPopularMovie() : LiveData<List<PopularMovieVO>>
    
    fun getUpComingMovie() : LiveData<List<UpcomingMovieVO>>

    fun getTopRateMovie() : LiveData<List<TopRateVO>>

    fun getSimilarMovie(movieId: Int) : Observable<List<SimilarMovieVO>>

    fun getCastMovie(movieId: Int) : Observable<List<CastVO>>

    fun getCrewMovie(movieId: Int) : Observable<List<CrewVO>>

    fun getGenreMovie() : Observable<List<GenresVO>>

    fun getMovieListById(movieId: Int) : Observable<List<MovieListVO>>
}