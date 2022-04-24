package com.krayapp.datamodule.model.retrofit

import android.widget.ImageView
import com.krayapp.datamodule.R
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