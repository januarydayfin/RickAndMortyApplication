package com.krayapp.rickandmortyapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickMortyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@RickMortyApp),
            modules(Koin.getModules())
        }
    }
}