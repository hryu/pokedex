package com.hyundai.pokedex.showpokemon.di

import com.hyundai.pokedex.core.domain.PokemonRepository
import com.hyundai.pokedex.showpokemon.domain.FakeGetPokemonListUseCase
import com.hyundai.pokedex.showpokemon.domain.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ShowPokemonModule::class]
)
object FakeShowPokemonModule {
    @Singleton
    @Provides
    fun provideGetPokemonListUseCase(pokemonRepository: PokemonRepository): GetPokemonListUseCase {
        return FakeGetPokemonListUseCase()
    }
}
