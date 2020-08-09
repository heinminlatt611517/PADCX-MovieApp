package com.example.padcx_movieapp_assignment.mvp.presenters

import com.example.padcx_movieapp_assignment.mvp.views.FragmentView
import com.example.shared.mvp.presenter.BasePresenter

interface FragmentPresenter :
    BasePresenter<FragmentView> {
    fun getMovieListByID(movieID : Int)
}