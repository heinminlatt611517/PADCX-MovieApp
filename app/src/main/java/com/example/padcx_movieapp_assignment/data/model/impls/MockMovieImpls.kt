package com.example.padcx_movieapp_assignment.data.model.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.vos.*
import com.example.padcx_movieapp_assignment.utils.POPULAR_MOVIE
import io.reactivex.Observable

object MockMovieImpls : MovieModel {

    override fun firstTimeNowPlayingMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun firstTimeUpComingMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun firstTimePopularMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun firstTimeTopRateMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllNowPlayingMovie(): LiveData<List<NowPlayingMovieVO>> {
        val liveData = MutableLiveData<List<NowPlayingMovieVO>>()
        liveData.postValue(
            listOf(
                NowPlayingMovieVO(),
                NowPlayingMovieVO(), NowPlayingMovieVO
                    ()
            )
        )
        return liveData
    }

    override fun getMovieById(movieId: Int): Observable<MovieVO> {
        TODO("Not yet implemented")
    }

    override fun getPopularMovie(): LiveData<List<PopularMovieVO>> {
        val liveData = MutableLiveData<List<PopularMovieVO>>()
        liveData.postValue(
            listOf(
                PopularMovieVO(),
                PopularMovieVO(), PopularMovieVO
                    ()
            )
        )
        return liveData
    }

    override fun getUpComingMovie(): LiveData<List<UpcomingMovieVO>> {
        val liveData = MutableLiveData<List<UpcomingMovieVO>>()
        liveData.postValue(listOf(UpcomingMovieVO(), UpcomingMovieVO(), UpcomingMovieVO()))
        return liveData
    }

    override fun getTopRateMovie(): LiveData<List<TopRateVO>> {
        val liveData = MutableLiveData<List<TopRateVO>>()
        liveData.postValue(listOf(TopRateVO(), TopRateVO(), TopRateVO()))
        return liveData
    }

    override fun getSimilarMovie(movieId: Int): Observable<List<SimilarMovieVO>> {
        TODO("Not yet implemented")
    }

    override fun getCastMovie(movieId: Int): Observable<List<CastVO>> {
        TODO("Not yet implemented")
    }

    override fun getCrewMovie(movieId: Int): Observable<List<CrewVO>> {
        TODO("Not yet implemented")
    }

    override fun getGenreMovie(): Observable<List<GenresVO>> {
        TODO("Not yet implemented")
    }

    override fun getMovieListById(movieId: Int): Observable<List<MovieListVO>> {
        TODO("Not yet implemented")
    }
}