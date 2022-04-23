package com.krayapp.rickandmortyapplication.model

import com.krayapp.rickandmortyapplication.model.retrofit.CharacterSource

class Repo(private val api:CharacterSource):IRepo {

    override suspend fun getAllCharacters(): List<CharacterInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCharacterById(id: Int): CharacterInfo {
        TODO("Not yet implemented")
    }
}