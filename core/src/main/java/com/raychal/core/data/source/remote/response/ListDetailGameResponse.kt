package com.raychal.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListDetailGameResponse(

    @field:SerializedName("results")
    val results: List<DetailGameResponse>

)

data class DetailGameResponse(
    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("background_image_additional")
    val backgroundImageAdditional: String,

    @field:SerializedName("description")
    val description: String,

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

    @field:SerializedName("updated")
    val updated: String,
)