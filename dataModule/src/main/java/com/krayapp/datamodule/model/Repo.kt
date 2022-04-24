package com.krayapp.datamodule.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.krayapp.datamodule.model.retrofit.CharacterSource
import retrofit2.HttpException

class Repo(private val api: CharacterSource) : IRepo {

    override suspend fun getAllCharacters(): Pager<Int,CharacterInfo> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 15),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            })


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