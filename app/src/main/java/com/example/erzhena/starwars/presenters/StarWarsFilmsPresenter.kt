package com.example.erzhena.starwars.presenters

import com.example.erzhena.starwars.api.StarWarsService
import com.example.erzhena.starwars.base.BasePresenter
import com.example.erzhena.starwars.contracts.StarWarFilmsContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StarWarsFilmsPresenter(private val starWarsService: StarWarsService) :
    StarWarFilmsContract.Presenter,
    BasePresenter<StarWarFilmsContract.View>() {

    override fun loadFilms() {
        starWarsService.getFilms()
            .map { it.filmsList }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.showContent(it)
                },
                {
                    view?.showError()
                }
            )
    }
}