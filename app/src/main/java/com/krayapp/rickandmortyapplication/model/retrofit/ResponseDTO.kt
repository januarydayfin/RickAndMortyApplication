package com.krayapp.rickandmortyapplication.model.retrofit

import com.google.gson.annotations.Expose

data class ResponseDTO (
    @Expose val results:List<CharacterDTO>
)
data class CharacterDTO (
    @Expose val id: Int,
    @Expose val name: String,
    @Expose val status: String,
    @Expose val species: String,
    @Expose val gender: String,
    @Expose val location: LocationDTO,
    @Expose val image: String,
    @Expose val episode: List<String>,
)
data class LocationDTO(
    @Expose val name: String
)