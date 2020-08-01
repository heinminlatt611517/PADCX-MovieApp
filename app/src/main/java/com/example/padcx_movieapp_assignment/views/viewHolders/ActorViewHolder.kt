package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.data.vos.CastVO
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.SimilarMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actors_layout.view.*

class ActorViewHolder(itemView: View) : BaseViewHolder<CastVO>(itemView) {
    override fun onItemClick(data: CastVO) {
    }

    override fun bindData(data: CastVO) {
       mData=data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.profilePath)
            .into(itemView.ivActor)

        itemView.tvActorName.text=data.name
    }
}