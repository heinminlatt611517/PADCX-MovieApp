package com.example.padcx_movieapp_assignment.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.view_pod_reaction.view.*

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate? =null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpListener(){
        tvMore.setOnClickListener {
          mDelegate?.onTapMore()
        }
    }

    fun setDelegate(delegate : Delegate){
        mDelegate=delegate
    }


    fun setData(title : String,titleMore : String){
        tvActor.text=title
        tvMore.text=titleMore
    }

    fun hideText(){
        tvMore.visibility= View.GONE
        tvDivider.visibility=View.GONE
    }

    fun showText(){
        tvMore.visibility= View.VISIBLE
        tvDivider.visibility=View.VISIBLE
    }


    interface Delegate{
       fun onTapMore()
    }
}