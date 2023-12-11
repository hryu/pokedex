package com.hyundai.pokedex.core.domain

import com.hyundai.pokedex.core.data.Resource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class PokeRepositoryUnitTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun `test getPokemonList returns success`() = runBlocking {
        val limit = 20
        val offset = 0
        val result = pokemonRepository.getPokemonList(limit, offset)

        assertTrue("Result should be a success", result is Resource.Success)
        assertNotNull("Data should not be null", (result as Resource.Success).data)

        val pokemons = result.data
        assertNotNull("Pokemons list should not be null", pokemons)
        assertEquals("Check the count of Pokemon returned", limit, pokemons?.size)

        // Asserting the first Pokemon's details
        val firstPokemon = pokemons?.firstOrNull()
        assertNotNull("First Pokemon should not be null", firstPokemon)
        assertEquals("First Pokemon should be bulbasaur", "bulbasaur", firstPokemon?.name)
        assertEquals("First Pokemon's imageUrl should be valid",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            firstPokemon?.imageUrl)
    }

    @Test
    fun `test getPokemonList handles errors`() = runBlocking {
        // Assuming FakePokeApi is set up to throw an exception for certain inputs
        val result = pokemonRepository.getPokemonList(-1, 0) // Use parameters that trigger an exception in FakePokeApi

        assertTrue("Result should be an error", result is Resource.Error)
        assertEquals("Limit and offset must be non-negative", (result as Resource.Error).message)
    }
}