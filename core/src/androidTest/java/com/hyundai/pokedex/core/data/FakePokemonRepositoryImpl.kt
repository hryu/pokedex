package com.hyundai.pokedex.core.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.core.domain.PokemonRepository
import javax.inject.Inject

class FakePokemonRepositoryImpl @Inject constructor() : PokemonRepository {

    private val fakePokemonData = arrayListOf(
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

    override fun getPokemonPagingSource(): PagingSource<Int, Pokemon> {
        return object : PagingSource<Int, Pokemon>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
                val position = params.key ?: 0
                val toIndex = minOf(position + params.loadSize, fakePokemonData.size)
                return LoadResult.Page(
                    data = fakePokemonData.subList(position, toIndex),
                    prevKey = if (position == 0) null else position - params.loadSize,
                    nextKey = if (toIndex == fakePokemonData.size) null else toIndex
                )
            }

            override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
                return state.anchorPosition
            }
        }
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<List<Pokemon>> {
        if (limit < 0 || offset < 0) {
            return Resource.Error("Limit and offset must be non-negative")
        }

        // Implement logic to return a portion of the list based on limit and offset
        return Resource.Success(fakePokemonData.subList(offset, minOf(offset + limit, fakePokemonData.size)))
    }
}