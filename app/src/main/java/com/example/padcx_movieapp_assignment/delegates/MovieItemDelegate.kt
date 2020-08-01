package com.example.padcx_movieapp_assignment.delegates

interface MovieItemDelegate {
    fun onTapMovieItem(movieId : Int)
    fun onTapPopularMovieItem(movieId: Int)
    fun onTapShowCaseItem(movieId: Int)
    fun onTapBestActorItem(movieId: Int)
}