package com.hyundai.pokedex.core.data.responses
import com.google.gson.annotations.SerializedName

data class PokemonDto (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)
