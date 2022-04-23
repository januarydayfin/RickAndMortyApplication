package com.krayapp.rickandmortyapplication

import com.krayapp.rickandmortyapplication.model.IRepo
import com.krayapp.rickandmortyapplication.model.Repo
import com.krayapp.rickandmortyapplication.model.retrofit.RickRetrofit
import com.krayapp.rickandmortyapplication.viewmodel.MainViewModel
import com.krayapp.rickandmortyapplication.viewmodel.OpenedCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    fun getModules() =
        module {
            single { RickRetrofit.getApi() }
            single<IRepo> { Repo(get()) }

            viewModel { MainViewModel(get()) }
            viewModel { OpenedCharacterViewModel(get()) }
        }

}