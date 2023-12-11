package com.hyundai.pokedex.core.data

import com.hyundai.pokedex.core.data.responses.PokemonDto
import com.hyundai.pokedex.core.data.responses.PokemonList
import javax.inject.Inject

class FakePokeApi @Inject constructor() : PokeApi {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList {
        if (limit < 0 || offset < 0) {
            throw IllegalArgumentException("Limit and offset must be non-negative")
        }

        // Hardcoded list of PokemonDto
        val fakePokemonList = arrayListOf(
            PokemonDto("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
            PokemonDto("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/"),
            PokemonDto("venusaur", "https://pokeapi.co/api/v2/pokemon/3/"),
            PokemonDto("charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
            PokemonDto("charmeleon", "https://pokeapi.co/api/v2/pokemon/5/"),
            PokemonDto("charizard", "https://pokeapi.co/api/v2/pokemon/6/"),
            PokemonDto("squirtle", "https://pokeapi.co/api/v2/pokemon/7/"),
            PokemonDto("wartortle", "https://pokeapi.co/api/v2/pokemon/8/"),
            PokemonDto("blastoise", "https://pokeapi.co/api/v2/pokemon/9/"),
            PokemonDto("caterpie", "https://pokeapi.co/api/v2/pokemon/10/"),
            PokemonDto("metapod", "https://pokeapi.co/api/v2/pokemon/11/"),
            PokemonDto("butterfree", "https://pokeapi.co/api/v2/pokemon/12/"),
            PokemonDto("weedle", "https://pokeapi.co/api/v2/pokemon/13/"),
            PokemonDto("kakuna", "https://pokeapi.co/api/v2/pokemon/14/"),
            PokemonDto("beedrill", "https://pokeapi.co/api/v2/pokemon/15/"),
            PokemonDto("pidgey", "https://pokeapi.co/api/v2/pokemon/16/"),
            PokemonDto("pidgeotto", "https://pokeapi.co/api/v2/pokemon/17/"),
            PokemonDto("pidgeot", "https://pokeapi.co/api/v2/pokemon/18/"),
            PokemonDto("rattata", "https://pokeapi.co/api/v2/pokemon/19/"),
            PokemonDto("raticate", "https://pokeapi.co/api/v2/pokemon/20/")
            // Add more PokemonDto as needed for testing
        )

        // Creating a PokemonList object with the hardcoded list and additional information
        return PokemonList(
            count = 1292,
            next = "https://pokeapi.co/api/v2/pokemon?offset=${offset + limit}&limit=$limit",
            previous = if (offset - limit >= 0) "https://pokeapi.co/api/v2/pokemon?offset=${offset - limit}&limit=$limit" else null,
            results = fakePokemonList
        )
    }
}
