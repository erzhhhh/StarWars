package com.example.erzhena.starwars.base

import com.example.erzhena.starwars.mvp.MvpPresenter
import com.example.erzhena.starwars.mvp.MvpView
import java.lang.ref.WeakReference

open class BasePresenter<V : MvpView> : MvpPresenter<V> {

    private var viewRef: WeakReference<V>? = null

    override fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    open var view: V? = null
        get() = viewRef?.get()

    override fun detachView() {
        viewRef?.clear()
        viewRef = null
    }
}