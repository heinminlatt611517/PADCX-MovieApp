package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.data.vos.TopRateVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.item_actors_layout.view.*

class BestActorViewHolder(private val mDelegate: MovieItemDelegate,itemView: View) : BaseViewHolder<TopRateVO>(itemView) {
    override fun onItemClick(data: TopRateVO) {
        mDelegate.onTapBestActorItem(data.id)
    }

    override fun bindData(data: TopRateVO) {
       mData=data

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.posterPath)
            .into(itemView.ivActor)

        itemView.tvActorName.text=data.originalTitle

    }
}