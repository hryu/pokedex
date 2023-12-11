package com.hyundai.pokedex.core.data

import android.util.Log
import com.hyundai.pokedex.core.data.responses.PokemonDto
import com.hyundai.pokedex.core.domain.Pokemon

object PokemonMapper {
    fun fromDto(pokemonDto: PokemonDto): Pokemon {
        val id = pokemonDto.url
            ?.removeSuffix("/")
            ?.substringAfterLast("/")
            ?.toIntOrNull()
            ?: 0
        val name = pokemonDto.name.orEmpty()
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
        return Pokemon(id, name, imageUrl)
    }
}
