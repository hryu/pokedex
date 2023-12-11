package com.hyundai.pokedex.core.data

import androidx.paging.PagingSource
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.core.domain.PokemonRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi
) : PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<List<Pokemon>> {
        return try {
            val response = api.getPokemonList(limit, offset)
            val pokemonList = response.results.map { dto ->
                PokemonMapper.fromDto(dto)
            }
            Resource.Success(pokemonList)
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred.")
        }
    }

    override fun getPokemonPagingSource(): PagingSource<Int, Pokemon> {
        return PokemonPagingSource(api)
    }
}