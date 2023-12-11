package com.hyundai.pokedex.core.data

import com.hyundai.pokedex.core.data.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList
}
