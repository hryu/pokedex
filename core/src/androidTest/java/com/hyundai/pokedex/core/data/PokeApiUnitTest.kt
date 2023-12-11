package com.hyundai.pokedex.core.data

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
class PokeApiUnitTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var pokeApi: PokeApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `test getPokemonList returns success`() {
        runBlocking {
            val pokemonList = pokeApi.getPokemonList(20, 0)

            assertNotNull("Pokemon list should not be null", pokemonList)
            assertEquals("Expected item count does not match", 20, pokemonList.results.size)
            assertTrue("Pokemon list should not be empty", pokemonList.results.isNotEmpty())

            // Example of asserting specific fields, adjust based on expected data
            val firstPokemon = pokemonList.results.firstOrNull()
            assertNotNull("First Pokemon should not be null", firstPokemon)
            assertNotNull("First Pokemon's name should not be null", firstPokemon?.name)
            assertNotNull("First Pokemon's URL should not be null", firstPokemon?.url)
        }
    }
}