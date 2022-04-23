package com.krayapp.rickandmortyapplication.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickRetrofit {
    private val baseUrl = "https://rickandmortyapi.com/"
    fun getApi():CharacterSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterSource::class.java)
}