package com.example.padcx_movieapp_assignment.mvp.views

import com.example.padcx_movieapp_assignment.data.vos.*

interface MainView : BaseView {
    fun showNowPlayingMovie(movieLists : List<NowPlayingMovieVO>)

    fun showPopularMovie(movieLists : List<PopularMovieVO>)

    fun navigateToMovieDetailScreen(movieId : Int)

    fun showNowPlayingMovieSlider(movieLists: List<NowPlayingMovieVO>)

    fun showUpComingMovie(movieLists: List<UpcomingMovieVO>)

    fun showTopRateMovie(movieLists: List<TopRateVO>)

    fun showGenreMovie(movieLists: List<GenresVO>)

    fun enableSwipeRefresh()

    fun disableSwipeRefresh()
}