package com.example.padcx_movieapp_assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.data.vos.UpcomingMovieVO
import com.example.padcx_movieapp_assignment.delegates.MovieItemDelegate
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import com.smarteist.autoimageslider.SliderViewAdapter

class TopMovieImageSliderAdapter(delegate: MovieItemDelegate,val list: ArrayList<NowPlayingMovieVO>, val context: Context) :
    SliderViewAdapter<TopMovieImageSliderAdapter.viewHolder>() {
    val mDelegate = delegate
    val listSize = 5
    open class viewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {

        var ivTopImageSlider: ImageView
        var tvMovieName : TextView


        init {
            ivTopImageSlider = view.findViewById(R.id.ivMovieSlider)
            tvMovieName = view.findViewById(R.id.tvMovieName)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?): viewHolder = viewHolder(
        LayoutInflater.from(
            parent!!.context
        ).inflate(R.layout.item_top_movie_image_slider, parent, false)
    )


    override fun getCount(): Int {
        if (list.size>5){
            return listSize
        }
        else return list.count()
    }
    override fun onBindViewHolder(viewHolder: viewHolder?, position: Int) {

        viewHolder?.tvMovieName?.text=list[position].originalTitle
        viewHolder?.ivTopImageSlider?.let {
            Glide.with(this.context).load(IMAGE_BASE_URL+list[position].backdropPath).into(
                it
            )
        }

        viewHolder?.ivTopImageSlider?.setOnClickListener {
            mDelegate.onTapTopMovieSliderImage(list[position].id)
        }



    }



    fun setData(imageList: ArrayList<NowPlayingMovieVO>) {

        list.clear()
        list.addAll(imageList)
        notifyDataSetChanged()

    }
}

