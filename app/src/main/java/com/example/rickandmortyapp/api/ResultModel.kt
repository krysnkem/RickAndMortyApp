package com.example.rickandmortyapp.api

import com.squareup.moshi.Json

data class ResultModel(

    @Json(name = "name")
    val name: String,
    @Json (name = "status")
    val status: String,
    @Json(name = "species")
    val species: String,
    @Json(name = "image")
    val image: String
)
