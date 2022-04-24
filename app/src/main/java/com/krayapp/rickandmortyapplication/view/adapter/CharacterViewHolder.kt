package com.krayapp.rickandmortyapplication.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.krayapp.rickandmortyapplication.databinding.CardTemplateBinding
import com.krayapp.datamodule.model.CharacterInfo
import com.krayapp.datamodule.model.retrofit.ImageLoader
import com.krayapp.rickandmortyapplication.view.OpenCharacterDelegate

class CharacterViewHolder(private val binding: CardTemplateBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(characterInfo: CharacterInfo, delegate: OpenCharacterDelegate) {
        with(binding) {
            gender.text = characterInfo.gender
            race.text = characterInfo.race
            name.text = characterInfo.name
            ImageLoader.loadPreview(characterInfo.image, image)
            root.setOnClickListener { delegate.clickCharacter(characterInfo.id) }
        }
    }
}