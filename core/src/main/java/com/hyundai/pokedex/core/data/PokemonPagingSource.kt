package com.hyundai.pokedex.core.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hyundai.pokedex.core.domain.Pokemon

class PokemonPagingSource(
    private val api: PokeApi
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val position = params.key ?: 0
        return try {
            val response = api.getPokemonList(params.loadSize, position)
            val pokemons = response.results.map { dto -> PokemonMapper.fromDto(dto) }
            val nextKey = if (pokemons.isEmpty()) null else position + params.loadSize
            LoadResult.Page(data = pokemons, prevKey = if (position == 0) null else position, nextKey = nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        // This is optional and can be adjusted based on your requirements
        return state.anchorPosition
    }
}
