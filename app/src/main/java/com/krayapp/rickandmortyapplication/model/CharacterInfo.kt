package com.krayapp.rickandmortyapplication.model

import com.google.gson.annotations.Expose
import com.krayapp.rickandmortyapplication.model.retrofit.LocationDTO

data class CharacterInfo(
    val id: Int,
    val name: String,
    val status: String,
    val race: String,
    val gender: String,
    val lastLocation: String,
    val image: String,
    val episodeCount: Int,
)