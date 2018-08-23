package com.example.erzhena.starwars.api

import com.example.erzhena.starwars.models.Films
import com.example.erzhena.starwars.models.Planets
import retrofit2.http.GET
import io.reactivex.Observable

interface StarWarsService {
    @GET("films/?format=json")
    fun getFilms() : Observable<Films>

    @GET("planets")
    fun getPlanets() : Observable<Planets>

}