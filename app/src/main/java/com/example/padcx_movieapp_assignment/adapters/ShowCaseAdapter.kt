package com.example.padcx_movieapp_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.UpcomingMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.views.viewHolders.BaseViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.ShowCaseViewHolder

class ShowCaseAdapter(delegate : MovieItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<UpcomingMovieVO>,UpcomingMovieVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<UpcomingMovieVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_showcase, parent, false)
        return ShowCaseViewHolder(mDelegate,view)
    }
}