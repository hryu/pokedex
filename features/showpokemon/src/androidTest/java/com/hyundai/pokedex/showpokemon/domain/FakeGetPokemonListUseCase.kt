package com.hyundai.pokedex.showpokemon.domain

import androidx.paging.PagingSource
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.showpokemon.data.FakePokemonPagingSource

class FakeGetPokemonListUseCase : GetPokemonListUseCase {
    override fun invoke(): PagingSource<Int, Pokemon> {
        // Return a fake PagingSource with mock data for testing
        return FakePokemonPagingSource()
    }
}
