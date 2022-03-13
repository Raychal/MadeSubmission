package com.raychal.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    var backgroundImage: String,
    var id: Int,
    var name: String,
    var playtime: Int,
    var rating: Double,
    var released: String,
    var backgroundImageAdditional: String,
    var description: String,
    var updated: String,
    var favorite: Boolean = false,
) : Parcelable