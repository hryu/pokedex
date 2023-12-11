package com.hyundai.pokedex.showpokemon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.showpokemon.domain.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    val pokemonList: Flow<PagingData<Pokemon>> = Pager(config = PagingConfig(pageSize = 20)) {
        getPokemonListUseCase()
    }.flow.cachedIn(viewModelScope)
}
