package com.krayapp.rickandmortyapplication.model

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface IRepo {
    suspend fun getAllCharacters(): Pager<Int, CharacterInfo>
    suspend fun fetchCharacterById(id:Int):CharacterInfo
}