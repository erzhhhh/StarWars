package com.example.erzhena.starwars.mvp


interface MvpPresenter<in V : MvpView> {

    fun attachView(view: V)

    fun detachView()
}