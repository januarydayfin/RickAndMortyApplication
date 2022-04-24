package com.krayapp.datamodule.model

import androidx.paging.Pager

interface IRepo {
    suspend fun getAllCharacters(): Pager<Int, CharacterInfo>
    suspend fun fetchCharacterById(id:Int):CharacterInfo
}