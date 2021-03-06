package com.krayapp.rickandmortyapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.krayapp.datamodule.model.CharacterInfo
import com.krayapp.datamodule.model.IRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

class MainViewModel(private val repo: IRepo) : ViewModel() {

    private var baseJob: Job? = null
    private val baseScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val _characterListFlow: MutableStateFlow<PagingData<CharacterInfo>> = MutableStateFlow(
        PagingData.empty()
    )

    val characterListFlow: StateFlow<PagingData<CharacterInfo>> = _characterListFlow.asStateFlow()

    val showRecyclerFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun loadCharacters() {
        baseJob?.cancel()
        baseJob = baseScope.launch {
            repo
                .getAllCharacters()
                .flow
                .cachedIn(viewModelScope)
                .collectLatest { value ->
                    _characterListFlow.value = value
                    showRecyclerFlow.value = true
                }
        }
    }
}