package com.example.padcx_movieapp_assignment.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null

    init {
        itemView.setOnClickListener {
            mData?.let {
                onItemClick(it)
            }
        }
    }

    abstract fun onItemClick(data: T)
    abstract fun bindData(data : T)
}