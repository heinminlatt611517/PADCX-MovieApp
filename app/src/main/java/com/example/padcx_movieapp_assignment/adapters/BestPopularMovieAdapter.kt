package com.example.padcx_movieapp_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.PopularMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.shared.viewholder.BaseViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.BestPopularMovieViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class BestPopularMovieAdapter(delegate : MovieItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<PopularMovieVO>, PopularMovieVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PopularMovieVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        return BestPopularMovieViewHolder(mDelegate,view)
        
    }
}