package com.example.padcx_movieapp_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.TopRateVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.views.viewHolders.BaseViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.BestActorViewHolder
import com.example.padcx_movieapp_assignment.views.viewHolders.ShowCaseViewHolder

class BestActorAdapter(delegate : MovieItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<TopRateVO>,TopRateVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TopRateVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_actors_layout, parent, false)
        return BestActorViewHolder(mDelegate,view)
    }
}