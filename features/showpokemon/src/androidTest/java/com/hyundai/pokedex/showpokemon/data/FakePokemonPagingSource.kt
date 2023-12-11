package com.hyundai.pokedex.showpokemon.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hyundai.pokedex.core.domain.Pokemon

class FakePokemonPagingSource : PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val data = generateFakePokemonList()
        return LoadResult.Page(data = data, prevKey = null, nextKey = null)
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return null
    }

    private fun generateFakePokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(1, "bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
            Pokemon(2, "ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
            Pokemon(3, "venusaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"),
            Pokemon(4, "charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
            Pokemon(5, "charmeleon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png"),
            Pokemon(6, "charizard", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"),
            Pokemon(7, "squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
            Pokemon(8, "wartortle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png"),
            Pokemon(9, "blastoise", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png"),
            Pokemon(10, "caterpie", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png"),
            Pokemon(11, "metapod", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png"),
            Pokemon(12, "butterfree", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png"),
            Pokemon(13, "weedle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png"),
            Pokemon(14, "kakuna", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png"),
            Pokemon(15, "beedrill", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png"),
            Pokemon(16, "pidgey", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png"),
            Pokemon(17, "pidgeotto", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png"),
            Pokemon(18, "pidgeot", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"),
            Pokemon(19, "rattata", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png"),
            Pokemon(20, "raticate", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png")
        )
    }
}
