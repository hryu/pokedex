package com.hyundai.pokedex.showpokemon.domain

import androidx.paging.PagingSource
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.core.domain.PokemonRepository
import javax.inject.Inject

interface GetPokemonListUseCase {
    operator fun invoke(): PagingSource<Int, Pokemon>
}
