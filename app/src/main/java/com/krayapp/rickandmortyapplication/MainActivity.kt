package com.krayapp.rickandmortyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krayapp.rickandmortyapplication.view.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,MainFragment.newInstance())
            .commitAllowingStateLoss()
    }
}