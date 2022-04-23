package com.krayapp.rickandmortyapplication.model.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterSource {
    @GET("api/character")
    suspend fun getAllCharacters(
        @Query("page") query: Int
    ):ResponseDTO
    @GET("api/character/{id}")
    suspend fun fetchCharacterById(@Path("id") id:Int):CharacterDTO
}