package com.example.erzhena.starwars.di.components

import android.content.Context
import com.example.erzhena.starwars.activities.MainActivity
import com.example.erzhena.starwars.api.StarWarsService
import com.example.erzhena.starwars.base.BaseActivity
import com.example.erzhena.starwars.di.modules.AppModule
import com.example.erzhena.starwars.presenters.StarWarsFilmsPresenter
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {

    fun exposeRetrofit(): Retrofit

    fun exposeContext(): Context

    fun injects(target: BaseActivity)

    fun injects(target: StarWarsFilmsPresenter)

    fun injects(target: StarWarsService)

    fun injects(target: MainActivity)
}