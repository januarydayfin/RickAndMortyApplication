package com.krayapp.rickandmortyapplication.model.retrofit

import com.google.gson.annotations.Expose

data class ResponseDTO (
     val info: InfoDTO,
     val results:List<CharacterDTO>
)
data class CharacterDTO (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val location: LocationDTO,
    val image: String,
    val episode: List<String>,
)
data class LocationDTO(
     val name: String
)
data class InfoDTO(
     val count: Int,
     val pages: Int,
     val next: String,
     val prev: Any? = null
)