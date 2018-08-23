package com.example.erzhena.starwars.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.erzhena.starwars.App
import com.example.erzhena.starwars.R
import com.example.erzhena.starwars.adapters.StarWarsFilmsAdapter
import com.example.erzhena.starwars.base.BaseActivity
import com.example.erzhena.starwars.contracts.StarWarFilmsContract
import com.example.erzhena.starwars.models.ConcreteFilm
import kotlinx.android.synthetic.main.activity_main.recyclerView
import javax.inject.Inject

open class MainActivity :
    BaseActivity(),
    StarWarFilmsContract.View {

    @Inject
    lateinit var filmsPresenter: StarWarFilmsContract.Presenter
    private lateinit var adapter: StarWarsFilmsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injects(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = StarWarsFilmsAdapter()
        recyclerView.adapter = adapter

        filmsPresenter.attachView(this)

        filmsPresenter.loadFilms()
    }

    override fun showContent(concreteFilm: List<ConcreteFilm>) {
        adapter.setItems(concreteFilm)

    }

    override fun showError() {
    }

}
