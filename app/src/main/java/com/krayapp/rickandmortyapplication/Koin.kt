package com.krayapp.rickandmortyapplication

import com.krayapp.rickandmortyapplication.model.IRepo
import com.krayapp.rickandmortyapplication.model.Repo
import com.krayapp.rickandmortyapplication.model.retrofit.RickRetrofit
import org.koin.dsl.module

object Koin {
    fun getModules() {
        module {
            single { RickRetrofit.getApi() }
            single<IRepo> { Repo(get()) }
        }
    }
}