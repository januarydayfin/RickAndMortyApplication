package com.krayapp.rickandmortyapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.krayapp.rickandmortyapplication.model.CharacterInfo
import com.krayapp.rickandmortyapplication.model.IRepo
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
                .collectLatest { value ->
                    _characterListFlow.value = value
                    showRecyclerFlow.value = true
                }
        }
    }
}