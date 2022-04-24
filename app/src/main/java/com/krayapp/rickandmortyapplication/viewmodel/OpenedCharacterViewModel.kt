package com.krayapp.rickandmortyapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.krayapp.datamodule.model.CharacterInfo
import com.krayapp.datamodule.model.IRepo
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