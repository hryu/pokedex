package com.hyundai.pokedex.core.data.responses
import com.google.gson.annotations.SerializedName

data class PokemonList (
    @SerializedName("count"    ) var count    : Int?               = null,
    @SerializedName("next"     ) var next     : String?            = null,
    @SerializedName("previous" ) var previous : String?            = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonDto> = arrayListOf()
)
