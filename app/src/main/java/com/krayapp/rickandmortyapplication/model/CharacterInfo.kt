package com.krayapp.rickandmortyapplication.model

data class CharacterInfo(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val race: String = "",
    val gender: String = "",
    val lastLocation: String = "",
    val image: String = "",
    val episodeCount: Int = 0,
)