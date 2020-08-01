package com.example.padcx_movieapp_assignment.mvp.views

import com.example.padcx_movieapp_assignment.data.vos.*

interface MovieDetailView : BaseView {
    fun showMovieById(movie : MovieVO)
    fun navigateToMain()
   fun showNowPlayingMovie(movieLists : List<NowPlayingMovieVO>)
    fun showCastMovie(movieLists: List<CastVO>)
    fun showCrewMovie(movieLists: List<CrewVO>)
}