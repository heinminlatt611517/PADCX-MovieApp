package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.CastVO
import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actors_layout.view.*
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