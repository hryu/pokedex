package com.hyundai.pokedex.showpokemon.domain

import androidx.paging.PagingSource
import com.hyundai.pokedex.core.data.Resource
import com.hyundai.pokedex.core.domain.Pokemon
import com.hyundai.pokedex.showpokemon.domain.GetPokemonListUseCase
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
class GetPokemonListUseCaseUnitTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getPokemonListUseCase: GetPokemonListUseCase

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `invoke returns correct data`() = runBlocking {
        val pagingSource = getPokemonListUseCase()
        val loadResult = pagingSource.load(PagingSource.LoadParams.Refresh(0, 20, false))
        assertTrue(loadResult is PagingSource.LoadResult.Page)
    }
}
