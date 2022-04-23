package com.krayapp.rickandmortyapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.krayapp.rickandmortyapplication.model.CharacterInfo
import com.krayapp.rickandmortyapplication.model.IRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OpenedCharacterViewModel(private val repo:IRepo):ViewModel() {

    private var _characterFlow: MutableStateFlow<CharacterInfo> = MutableStateFlow(CharacterInfo())
    val characterFlow: StateFlow<CharacterInfo> = _characterFlow.asStateFlow()

    private var baseJob: Job? = null
    private val baseScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    fun getCharacterById(id:Int){
        baseJob?.cancel()
        baseJob = baseScope.launch {
           _characterFlow.value = repo.fetchCharacterById(id)
        }
    }
}