package com.krayapp.rickandmortyapplication

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.krayapp.datamodule.model.CharacterInfo
import com.krayapp.datamodule.model.retrofit.CharacterDTO


fun Fragment.toast(text:String) = Toast.makeText(context,text, Toast.LENGTH_SHORT).show()