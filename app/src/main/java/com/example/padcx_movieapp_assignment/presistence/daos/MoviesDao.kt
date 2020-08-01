package com.example.padcx_movieapp_assignment.presistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.PopularMovieVO
import com.example.padcx_movieapp_assignment.data.vos.TopRateVO
import com.example.padcx_movieapp_assignment.data.vos.UpcomingMovieVO

@Dao
interface MoviesDao {
    @Query("SELECT * FROM NowPlaying")
    fun getAllNowPlayingMovies(): LiveData<List<NowPlayingMovieVO>>

    @Query("SELECT * FROM topRate")
    fun getAllTopRateMovie(): LiveData<List<TopRateVO>>

    @Query("SELECT * FROM upComing")
    fun getAllUpComingMovies(): LiveData<List<UpcomingMovieVO>>

    @Query("SELECT * FROM popular")
    fun getAllPopularMovies(): LiveData<List<PopularMovieVO>>

    @Query("SELECT * FROM NowPlaying WHERE id = :movieID")
    fun getNowPlayingMovieById(movieID: Int) : LiveData<NowPlayingMovieVO>

    @Query("SELECT * FROM upComing WHERE id = :movieID")
    fun getUpComingMovieById(movieID: Int) : LiveData<UpcomingMovieVO>

    @Query("SELECT * FROM popular WHERE id = :movieID")
    fun getPopularMovieById(movieID: Int) : LiveData<PopularMovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNowPlayingMovie(movies: List<NowPlayingMovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUpComingMovie(movies: List<UpcomingMovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovie(movies: List<PopularMovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTopRateMovie(movies: List<TopRateVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingMovie(movies: NowPlayingMovieVO)



}