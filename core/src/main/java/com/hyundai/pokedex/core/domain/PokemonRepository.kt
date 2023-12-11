package com.hyundai.pokedex.core.domain

import androidx.paging.PagingSource
import com.hyundai.pokedex.core.data.Resource
import com.hyundai.pokedex.core.data.responses.PokemonList

interface PokemonRepository {
    // Existing function to get a list of Pokemon
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<List<Pokemon>>

    // Function to provide a PagingSource for Pokemon
    fun getPokemonPagingSource(): PagingSource<Int, Pokemon>
}