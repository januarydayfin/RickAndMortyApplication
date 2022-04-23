package com.krayapp.rickandmortyapplication.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.krayapp.rickandmortyapplication.model.retrofit.CharacterSource
import com.krayapp.rickandmortyapplication.toCharacterInfo
import com.krayapp.rickandmortyapplication.view.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException

class Repo(private val api: CharacterSource) : IRepo {

    override suspend fun getAllCharacters(): Flow<PagingData<CharacterInfo>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 15),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            }).flow


    override suspend fun fetchCharacterById(id: Int): CharacterInfo {
        try {
            val response = api.fetchCharacterById(id)
            return response.toCharacterInfo()
        } catch (e: HttpException) {
            throw Exception(e)
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}