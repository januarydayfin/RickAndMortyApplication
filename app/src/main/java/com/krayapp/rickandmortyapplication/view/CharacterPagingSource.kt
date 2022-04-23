package com.krayapp.rickandmortyapplication.view

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.krayapp.rickandmortyapplication.model.CharacterInfo
import com.krayapp.rickandmortyapplication.model.retrofit.CharacterSource
import com.krayapp.rickandmortyapplication.toCharacterInfo

class CharacterPagingSource (private val characterSource: CharacterSource) : PagingSource<Int, CharacterInfo>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterInfo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterInfo> {
        return try {
            val nextPage : Int = params.key ?: FIRST_PAGE_INDEX
            val response = characterSource.getAllCharacters(nextPage)
            var nextPageNumber : Int? = null
            val characterInfoList = mutableListOf<CharacterInfo>()

            if (response.info.next != null){
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            for (character in response.results){
                characterInfoList.add(character.toCharacterInfo())
            }

            LoadResult.Page(data = characterInfoList, prevKey = null, nextKey = nextPageNumber)

        }catch(e: Exception){
            LoadResult.Error(e)
        }
    }

    companion object{
        private const val FIRST_PAGE_INDEX = 1
    }
}