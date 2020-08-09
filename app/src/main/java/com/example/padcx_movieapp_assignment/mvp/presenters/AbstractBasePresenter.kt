package com.example.padcx_movieapp_assignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.shared.mvp.view.BaseView
import com.example.shared.mvp.presenter.BasePresenter

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>,ViewModel() {
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView=view
    }
}