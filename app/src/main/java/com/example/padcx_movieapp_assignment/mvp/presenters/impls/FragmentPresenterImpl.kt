package com.example.padcx_movieapp_assignment.mvp.presenters.impls

import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl
import com.example.padcx_movieapp_assignment.mvp.presenters.AbstractBasePresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.FragmentPresenter
import com.example.padcx_movieapp_assignment.mvp.views.FragmentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentPresenterImpl : FragmentPresenter,AbstractBasePresenter<FragmentView>() {
    private var mMovieModel : MovieModel =
        MovieModelImpl
    override fun getMovieListByID(movieID: Int) {
       mMovieModel.getMovieListById(movieID)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               mView?.showMovieList(it.toMutableList())
           },{
               mView?.showErrorMessage(it.localizedMessage)
           })
    }
}