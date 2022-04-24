package com.krayapp.rickandmortyapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.krayapp.rickandmortyapplication.databinding.CardTemplateBinding
import com.krayapp.datamodule.model.CharacterInfo
import com.krayapp.rickandmortyapplication.view.OpenCharacterDelegate

class CharacterAdapter(private val delegate: OpenCharacterDelegate) :
    PagingDataAdapter<CharacterInfo, CharacterViewHolder>(CharacterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CardTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position)!!, delegate)
    }

}