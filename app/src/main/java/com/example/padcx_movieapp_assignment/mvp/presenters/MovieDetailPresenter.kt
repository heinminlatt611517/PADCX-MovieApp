package com.example.padcx_movieapp_assignment.mvp.presenters

import com.example.padcx_movieapp_assignment.mvp.views.MovieDetailView
import com.example.padcx_movieapp_assignment.views.viewPods.ReactionViewPod

interface MovieDetailPresenter : BasePresenter<MovieDetailView> ,ReactionViewPod.Delegate {
    fun getMovieByID(id : Int)
    fun getNowPlayingMovie()
    fun getCastMovieByID(id: Int)
    fun getCrewMovieByID(id: Int)
}