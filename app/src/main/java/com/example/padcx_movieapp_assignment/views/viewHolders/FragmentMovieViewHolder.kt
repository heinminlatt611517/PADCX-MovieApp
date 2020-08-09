package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_movie_detail.view.*
import kotlinx.android.synthetic.main.activity_movie_detail.view.tvMovieTitle
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class FragmentMovieViewHolder(itemView: View) : BaseViewHolder<MovieListVO>(itemView) {
    override fun onItemClick(data: MovieListVO) {
    }

    override fun bindData(data: MovieListVO) {
       mData=data
        itemView.tvMovieTitle.text=data.name
        

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.posterPath)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
            .into(itemView.ivMovie)

    }
}