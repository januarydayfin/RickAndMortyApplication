package com.krayapp.rickandmortyapplication

import android.content.Context
import android.net.ConnectivityManager
import com.krayapp.datamodule.model.IRepo
import com.krayapp.datamodule.model.Repo
import com.krayapp.datamodule.model.retrofit.RickRetrofit
import com.krayapp.rickandmortyapplication.viewmodel.MainViewModel
import com.krayapp.rickandmortyapplication.viewmodel.OpenedCharacterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    fun getModules() =
        module {
            single { RickRetrofit.getApi() }
            single<IRepo> { Repo(get()) }
            single {androidApplication().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
            single { NetworkListener(get()) }

            viewModel { MainViewModel(get()) }
            viewModel { OpenedCharacterViewModel(get()) }
        }

}