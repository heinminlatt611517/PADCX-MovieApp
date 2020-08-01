package com.example.padcx_movieapp_assignment.views.viewHolders

import android.graphics.Movie
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.data.vos.UpcomingMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowCaseViewHolder(private val mDelegate : MovieItemDelegate,itemView: View) : BaseViewHolder<UpcomingMovieVO>(itemView) {
    override fun onItemClick(data: UpcomingMovieVO) {
        mDelegate.onTapShowCaseItem(data.id)
    }

    override fun bindData(data: UpcomingMovieVO) {
       mData=data

        itemView.tvMovieName.text=data.originalTitle
        itemView.tvDate.text=data.releaseData
        Glide.with(itemView.context).load(IMAGE_BASE_URL+data.posterPath)
            .into(itemView.ivActor)


    }
}