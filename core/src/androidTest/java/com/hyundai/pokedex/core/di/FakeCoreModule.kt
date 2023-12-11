package com.hyundai.pokedex.core.di

import com.hyundai.pokedex.core.data.FakePokeApi
import com.hyundai.pokedex.core.data.PokeApi
import com.hyundai.pokedex.core.data.FakePokemonRepositoryImpl
import com.hyundai.pokedex.core.domain.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoreModule::class]
)
object FakeCoreModule {
    @Provides
    @Singleton
    fun providePokeApi(): PokeApi {
        return FakePokeApi()
    }

    @Singleton
    @Provides
    fun providePokemonRepository(): PokemonRepository {
        return FakePokemonRepositoryImpl()
    }
}
