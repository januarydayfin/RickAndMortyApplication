package com.krayapp.rickandmortyapplication.model

interface IRepo {
    suspend fun getAllCharacters():List<CharacterInfo>
    suspend fun fetchCharacterById(id:Int):CharacterInfo
}