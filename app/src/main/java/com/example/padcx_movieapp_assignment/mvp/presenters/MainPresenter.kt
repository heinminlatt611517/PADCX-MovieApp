package com.example.padcx_movieapp_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> ,MovieItemDelegate {

    fun onUIReady(lifecycleOwner: LifecycleOwner)
    fun onPopularMovie(lifecycleOwner: LifecycleOwner)
    fun onUpComingMovie(lifecycleOwner: LifecycleOwner)
    fun onTopRateMovie(lifecycleOwner: LifecycleOwner)
    fun onGenreMovie()

}