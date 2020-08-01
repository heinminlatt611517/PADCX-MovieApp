package com.example.padcx_movieapp_assignment.mvp.presenters

import com.example.padcx_movieapp_assignment.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view : T)
}