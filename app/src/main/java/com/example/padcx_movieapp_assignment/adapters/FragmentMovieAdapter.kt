package com.example.padcx_movieapp_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.CastVO
import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.example.padcx_movieapp_assignment.views.viewHolders.ActorViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.BaseViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.FragmentMovieViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.ShowCaseViewHolder

class FragmentMovieAdapter : BaseRecyclerAdapter<BaseViewHolder<MovieListVO>,MovieListVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieListVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        return FragmentMovieViewHolder(view)
    }
}