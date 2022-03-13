package com.raychal.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(

    @field:SerializedName("results")
    val results: List<GameResponse>

)

data class GameResponse(
    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("playtime")
    val playtime: Int,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("released")
    val released: String,
)