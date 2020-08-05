package com.example.padcx_movieapp_assignment.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl
import com.example.padcx_movieapp_assignment.mvp.presenters.AbstractBasePresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.MainPresenter
import com.example.padcx_movieapp_assignment.mvp.views.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl : MainPresenter,
    AbstractBasePresenter<MainView>() {
    var mMovieModel : MovieModel =
        MovieModelImpl
    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
      getAllNowPlayingMovies(lifecycleOwner)
    }

    override fun onPopularMovie(lifecycleOwner: LifecycleOwner) {
        getPopularMovie(lifecycleOwner)
    }

    override fun onUpComingMovie(lifecycleOwner: LifecycleOwner) {
        getUpComingMovie(lifecycleOwner)
    }

    override fun onTopRateMovie(lifecycleOwner: LifecycleOwner) {
        getTopRateMovie(lifecycleOwner)
    }

    override fun onGenreMovie() {
       getGenreMovie()
    }

    override fun onTapMovieItem(movieId: Int) {
        mView?.navigateToMovieDetailScreen(movieId)
    }

    override fun onTapPopularMovieItem(movieId: Int) {
        mView?.navigateToMovieDetailScreen(movieId)
    }

    override fun onTapShowCaseItem(movieId: Int) {
        mView?.navigateToMovieDetailScreen(movieId)
    }

    override fun onTapBestActorItem(movieId: Int) {
        mView?.navigateToMovieDetailScreen(movieId)
    }

    override fun onTapTopMovieSliderImage(movieId: Int) {
        mView?.navigateToMovieDetailScreen(movieId)
    }

    fun getAllNowPlayingMovies(lifecycleOwner: LifecycleOwner){
        mMovieModel.getAllNowPlayingMovie()
            .observe(lifecycleOwner, Observer {
                mView?.showNowPlayingMovieSlider(it)
            })
    }

    fun getPopularMovie(lifecycleOwner: LifecycleOwner){
        mMovieModel.getPopularMovie()
            .observe(lifecycleOwner, Observer {
                mView?.showPopularMovie(it)
            })

    }

    fun getUpComingMovie(lifecycleOwner: LifecycleOwner){
        mMovieModel.getUpComingMovie()
            .observe(lifecycleOwner, Observer {
                mView?.showUpComingMovie(it)
            })

    }

    fun getTopRateMovie(lifecycleOwner: LifecycleOwner){
        mMovieModel.getTopRateMovie()
            .observe(lifecycleOwner, Observer {
                mView?.showTopRateMovie(it)
            })
    }

    fun getGenreMovie(){
        mMovieModel.getGenreMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.showGenreMovie(it.toMutableList())
            },{
                mView?.showErrorMessage(it.localizedMessage)
            })
    }
}