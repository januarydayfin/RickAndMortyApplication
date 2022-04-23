package com.krayapp.rickandmortyapplication

import com.krayapp.rickandmortyapplication.model.CharacterInfo
import com.krayapp.rickandmortyapplication.model.retrofit.CharacterDTO

fun CharacterDTO.toCharacterInfo() =
    CharacterInfo(
        id = this.id,
        name = this.name,
        status = this.status,
        race = this.species,
        gender = this.gender,
        lastLocation = this.location.name,
        image = this.image,
        episodeCount = this.episode.size
    )