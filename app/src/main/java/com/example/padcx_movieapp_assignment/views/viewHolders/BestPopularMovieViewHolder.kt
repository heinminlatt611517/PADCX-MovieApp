package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.data.vos.PopularMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class BestPopularMovieViewHolder(private val mDelegate : MovieItemDelegate,itemView: View) : BaseViewHolder<PopularMovieVO>(itemView) {
    override fun onItemClick(data: PopularMovieVO) {
        mDelegate.onTapPopularMovieItem(data.id)
    }

    override fun bindData(data: PopularMovieVO) {
       mData=data
        itemView.tvMovieTitle.text=data.title
        itemView.tvRateCount.text= data.popularity
        itemView.rating.rating=data.voteAverage

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.posterPath)
            .into(itemView.ivMovie)

    }
}