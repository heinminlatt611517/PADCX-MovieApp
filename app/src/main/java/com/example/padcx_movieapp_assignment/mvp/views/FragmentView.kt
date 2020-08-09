package com.example.padcx_movieapp_assignment.mvp.views

import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.shared.mvp.view.BaseView

interface FragmentView : BaseView {
    fun showMovieList(movieLists : List<MovieListVO>)
}