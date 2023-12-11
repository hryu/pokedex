package com.hyundai.pokedex.core.di

import com.hyundai.pokedex.core.data.PokeApi
import com.hyundai.pokedex.core.data.PokemonRepositoryImpl
import com.hyundai.pokedex.core.domain.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Singleton
    @Provides
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
            .create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }
}
