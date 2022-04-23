package com.krayapp.rickandmortyapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.rickandmortyapplication.databinding.ActivityMainBinding
import com.krayapp.rickandmortyapplication.view.MainFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val networkListener: NetworkListener by inject()
    override fun onResume() {
        super.onResume()
        if (networkListener.isOnline()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitAllowingStateLoss()
        } else {
            Toast.makeText(this, "Need internet connection", Toast.LENGTH_SHORT).show()
        }
    }

}