package com.example.erzhena.starwars.contracts

import com.example.erzhena.starwars.models.ConcreteFilm
import com.example.erzhena.starwars.mvp.MvpPresenter
import com.example.erzhena.starwars.mvp.MvpView

interface StarWarFilmsContract {

    interface View : MvpView {

        fun showContent(concreteFilm: List<ConcreteFilm>)

        fun showError()
    }

    interface Presenter : MvpPresenter<View> {

        fun loadFilms()
    }
}