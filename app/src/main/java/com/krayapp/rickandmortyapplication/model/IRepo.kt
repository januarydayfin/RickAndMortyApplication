package com.krayapp.rickandmortyapplication.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface IRepo {
    suspend fun getAllCharacters(): Flow<PagingData<CharacterInfo>>
    suspend fun fetchCharacterById(id:Int):CharacterInfo
}