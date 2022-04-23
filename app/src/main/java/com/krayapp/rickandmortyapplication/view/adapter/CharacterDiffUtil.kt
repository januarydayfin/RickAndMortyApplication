package com.krayapp.rickandmortyapplication.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.krayapp.rickandmortyapplication.model.CharacterInfo

class CharacterDiffUtil:DiffUtil.ItemCallback<CharacterInfo>() {
    override fun areItemsTheSame(oldItem: CharacterInfo, newItem: CharacterInfo): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CharacterInfo, newItem: CharacterInfo): Boolean =
        oldItem.id == newItem.id
}