package com.hyundai.pokedex.showpokemon.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.hyundai.pokedex.core.domain.Pokemon

@Composable
fun PokemonListView(
    viewModel: PokemonViewModel
) {
    val pokemonList = viewModel.pokemonList.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(pokemonList.itemCount) { index ->
            val pokemon = pokemonList[index]
            PokemonItem(pokemon)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon?) {
    Card (
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(), // Fill the available space
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, // Center vertically
                horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
            ) {
                AsyncImage(
                    model = pokemon?.imageUrl,
                    contentDescription = null,
                )
                Text(text = pokemon?.name ?: "")
            }
        }
    )
}
