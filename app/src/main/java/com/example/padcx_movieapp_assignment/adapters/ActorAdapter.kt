package com.example.padcx_movieapp_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.CastVO
import com.example.padcx_movieapp_assignment.views.viewHolders.ActorViewHolder
import com.example.shared.viewholder.BaseViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class ActorAdapter : BaseRecyclerAdapter<BaseViewHolder<CastVO>, CastVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CastVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_actors_layout, parent, false)
        return ActorViewHolder(view)
    }
}