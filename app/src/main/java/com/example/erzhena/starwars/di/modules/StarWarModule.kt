package com.example.erzhena.starwars.di.modules

import com.example.erzhena.starwars.api.StarWarsService
import com.example.erzhena.starwars.contracts.StarWarFilmsContract
import com.example.erzhena.starwars.presenters.StarWarsFilmsPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class StarWarModule {

    @Singleton
    @Provides
    fun provideStarWarService(retrofit: Retrofit): StarWarsService {
        return retrofit.create(StarWarsService::class.java)
    }

    @Provides
    fun provideStarWarsFilmPresenter(starWarsService: StarWarsService): StarWarFilmsContract.Presenter = StarWarsFilmsPresenter(starWarsService)
}