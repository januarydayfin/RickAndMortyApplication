package com.krayapp.rickandmortyapplication.model.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterSource {
    @GET("api/character")
    suspend fun getAllCharacters():Response<ResponseDTO>
    @GET("api/character/{id}")
    suspend fun fetchCharacterById(@Path("id") id:Int):Response<CharacterDTO>
}