package com.hyundai.pokedex.showpokemon.di

import com.hyundai.pokedex.core.domain.PokemonRepository
import com.hyundai.pokedex.showpokemon.domain.GetPokemonListUseCase
import com.hyundai.pokedex.showpokemon.domain.GetPokemonListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShowPokemonModule {
    @Singleton
    @Provides
    fun provideGetPokemonListUseCase(pokemonRepository: PokemonRepository): GetPokemonListUseCase {
        return GetPokemonListUseCaseImpl(pokemonRepository)
    }
}
