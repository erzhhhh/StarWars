package com.example.erzhena.starwars

import android.app.Application
import com.example.erzhena.starwars.di.components.AppComponent
import com.example.erzhena.starwars.di.components.DaggerAppComponent
import com.example.erzhena.starwars.di.modules.AppModule

class App : Application() {

    companion object {
        private lateinit var instance : App

        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        instance = this
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this, "https://swapi.co/api/"))
            .build()
        super.onCreate()
    }
}