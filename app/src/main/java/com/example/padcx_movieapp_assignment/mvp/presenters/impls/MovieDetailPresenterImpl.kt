package com.example.padcx_movieapp_assignment.mvp.presenters.impls

import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl
import com.example.padcx_movieapp_assignment.mvp.presenters.AbstractBasePresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.MovieDetailPresenter
import com.example.padcx_movieapp_assignment.mvp.views.MovieDetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailPresenterImpl : MovieDetailPresenter,AbstractBasePresenter<MovieDetailView>() {
    var mMovieModel : MovieModel =
        MovieModelImpl
    override fun getMovieByID(id: Int) {
        mMovieModel.getMovieById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.showMovieById(it)
            },{
                mView?.showErrorMessage(it.localizedMessage)
            })
    }

    override fun getNowPlayingMovie() {
//        mMovieModel.getNowPlayingMovie()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mView?.showNowPlayingMovie(it)
//            },{
//                mView?.showErrorMessage(it.localizedMessage)
//            })
    }

    override fun getCastMovieByID(id: Int) {
        mMovieModel.getCastMovie(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.showCastMovie(it)
            },{
                mView?.showErrorMessage(it.localizedMessage)
            })

    }

    override fun getCrewMovieByID(id: Int) {
        mMovieModel.getCrewMovie(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.showCrewMovie(it)
            },{
                mView?.showErrorMessage(it.localizedMessage)
            })

    }

    override fun onTapMore() {
        mView?.navigateToMain()
    }
}