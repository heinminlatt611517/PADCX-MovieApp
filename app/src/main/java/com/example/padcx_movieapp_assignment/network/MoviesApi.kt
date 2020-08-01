package com.example.padcx_movieapp_assignment.network

import com.example.padcx_movieapp_assignment.data.vos.MovieVO
import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.example.padcx_movieapp_assignment.network.response.*
import com.example.padcx_movieapp_assignment.utils.*
import io.reactivex.Observable
import retrofit2.http.*

interface MoviesApi {


    @GET(NOW_PLAYING_MOVIE)
    fun getNowPlayingMovie(@Query(PARAM_API_KEY) api_key : String)
            : Observable<NowPlayingMovieResponse>



    @GET("$MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetailById(@Path("MOVIE_ID") movieId: Int,@Query(PARAM_API_KEY) api_key: String) :Observable<MovieVO>


    @GET(POPULAR_MOVIE)
    fun getPopularMovie(@Query(PARAM_API_KEY) api_key: String)
            :Observable<PopularMovieResponse>

    @GET(UPCOMING_MOVIE)
    fun getUpComingMovie(@Query(PARAM_API_KEY) api_key: String) : Observable<UpComingMovieResponse>


    @GET(TOPRATE_MOVIE)
    fun getTopMovie(@Query(PARAM_API_KEY) api_key: String) : Observable<TopRateMovieResponse>

    @GET("$SIMILAR_MOVIE/{MOVIE_ID}/similar")
    fun getSimilarMovie(@Path("MOVIE_ID") movieId: Int,@Query(PARAM_API_KEY) api_key: String) :Observable<SimilarMovieResponse>

    @GET("$CAST_AND_CREW/{MOVIE_ID}/casts")
    fun getCastAndCrewMovie(@Path("MOVIE_ID") movieId: Int,@Query(PARAM_API_KEY) api_key: String) :Observable<CastAndCrewMovieResponse>

    @GET(GENRE_MOVIE)
    fun getGenreMovie(@Query(PARAM_API_KEY) api_key: String) : Observable<GenreMovieResponse>

    @GET("$MOVIE_LIST/{MOVIE_ID}/lists")
    fun getMovieListById(@Path("MOVIE_ID") movieId: Int,@Query(PARAM_API_KEY) api_key: String) :
            Observable<MovieListResponse>




}