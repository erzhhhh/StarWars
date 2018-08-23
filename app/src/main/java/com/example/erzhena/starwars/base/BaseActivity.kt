package com.example.erzhena.starwars.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.erzhena.starwars.App

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injects(this)
        super.onCreate(savedInstanceState)
    }
}