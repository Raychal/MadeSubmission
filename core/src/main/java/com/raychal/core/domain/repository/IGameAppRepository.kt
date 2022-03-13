package com.raychal.core.domain.repository

import com.raychal.core.data.Resource
import com.raychal.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameAppRepository {
    fun getAllGames(sort: String): Flow<Resource<List<Game>>>

    fun getFavoriteGames(sort: String): Flow<List<Game>>

    fun getSearchGames(search: String): Flow<List<Game>>

    fun setGameFavorite(game: Game, state: Boolean)
}