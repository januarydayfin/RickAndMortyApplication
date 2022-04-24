package com.krayapp.datamodule.model

import com.krayapp.datamodule.model.retrofit.CharacterDTO

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