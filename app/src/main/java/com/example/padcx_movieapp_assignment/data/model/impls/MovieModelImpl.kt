package com.example.padcx_movieapp_assignment.data.model.impls

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padcx_movieapp_assignment.BuildConfig
import com.example.padcx_movieapp_assignment.data.model.BaseModel
import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.vos.*
import com.example.padcx_movieapp_assignment.utils.API_KEY

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : MovieModel,
    BaseModel() {
    override fun firstTimeNowPlayingMovieSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getNowPlayingMovie(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.retult }
            .subscribe {
              mMovieDb.moviesDao().insertAllNowPlayingMovie(it)
            }
    }

    override fun firstTimeUpComingMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMoviesApi.getUpComingMovie(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.retult }
            .subscribe({
                mMovieDb.moviesDao().insertAllUpComingMovie(it)
            },{
                Log.d("UpComingError",it.localizedMessage)
            })
    }

    override fun firstTimePopularMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMoviesApi.getPopularMovie(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .subscribe {
                mMovieDb.moviesDao().insertAllPopularMovie(it)
            }
    }

    override fun firstTimeTopRateMovieSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMoviesApi.getTopMovie(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .subscribe({
                mMovieDb.moviesDao().insertAllTopRateMovie(it)
            },{
                Log.d("TopRateError",it.localizedMessage)
            })
    }

    override fun getAllNowPlayingMovie(): LiveData<List<NowPlayingMovieVO>> {
       return mMovieDb.moviesDao().getAllNowPlayingMovies()
    }


    override fun getMovieById(movieId: Int): Observable<MovieVO> {
        return mMoviesApi.getMovieDetailById(movieId, BuildConfig.API_KEY)
    }

    override fun getPopularMovie(): LiveData<List<PopularMovieVO>> {
        return mMovieDb.moviesDao().getAllPopularMovies()

    }

    override fun getUpComingMovie(): LiveData<List<UpcomingMovieVO>> {
        return mMovieDb.moviesDao().getAllUpComingMovies()
    }



    override fun getTopRateMovie(): LiveData<List<TopRateVO>> {
        return mMovieDb.moviesDao().getAllTopRateMovie()
    }

    override fun getSimilarMovie(movieId: Int): Observable<List<SimilarMovieVO>> {
        return mMoviesApi.getSimilarMovie(movieId, BuildConfig.API_KEY)
            .map { it.results }

    }

    override fun getCastMovie(movieId: Int): Observable<List<CastVO>> {
      return  mMoviesApi.getCastAndCrewMovie(movieId, BuildConfig.API_KEY)
            .map { it.cast }
    }

    override fun getCrewMovie(movieId: Int): Observable<List<CrewVO>> {
        return  mMoviesApi.getCastAndCrewMovie(movieId, BuildConfig.API_KEY)
            .map { it.crew }
    }

    override fun getGenreMovie(): Observable<List<GenresVO>> {
        return mMoviesApi?.getGenreMovie(BuildConfig.API_KEY)
            .map { it.genres }
    }

    override fun getMovieListById(movieId: Int): Observable<List<MovieListVO>> {
        return mMoviesApi.getMovieListById(movieId, BuildConfig.API_KEY)
            .map { it.results }
    }

}