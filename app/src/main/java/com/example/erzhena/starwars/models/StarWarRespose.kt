package com.example.erzhena.starwars.models

import com.google.gson.annotations.SerializedName

data class Films(
    @SerializedName("results")
    val filmsList: List<ConcreteFilm>
)

data class ConcreteFilm(
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val releaseDate: String
)

data class Planets(
    @SerializedName("results")
    val planet: List<ConcretePlanet>
)

data class ConcretePlanet(
    val name: String,
    val rotationPeriod: String,
    val population: String
)