package com.example.padcx_movieapp_assignment.mvp.presenters

import com.example.padcx_movieapp_assignment.mvp.views.FragmentView

interface FragmentPresenter : BasePresenter<FragmentView> {
    fun getMovieListByID(movieID : Int)
}