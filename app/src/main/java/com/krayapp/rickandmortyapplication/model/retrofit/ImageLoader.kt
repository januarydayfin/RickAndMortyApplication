package com.krayapp.rickandmortyapplication.model.retrofit

import android.widget.ImageView
import com.krayapp.rickandmortyapplication.MainActivity
import com.krayapp.rickandmortyapplication.R
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadPreview(url:String, container:ImageView){
        Picasso
            .get()
            .load(url)
            .placeholder(R.drawable.hell)
            .resize(400,400)
            .into(container)
    }
    fun loadPortrait(url:String, container:ImageView){
        Picasso
            .get()
            .load(url)
            .placeholder(R.drawable.hell)
            .resize(1080,1080)
            .into(container)
    }
}