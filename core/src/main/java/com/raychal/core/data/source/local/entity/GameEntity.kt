package com.raychal.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameEntities")
class GameEntity (
    @ColumnInfo(name = "background_image")
    var backgroundImage: String,

    @ColumnInfo(name = "background_image_additional")
    var backgroundImageAdditional: String,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "playtime")
    var playtime: Int,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "updated")
    var updated: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)