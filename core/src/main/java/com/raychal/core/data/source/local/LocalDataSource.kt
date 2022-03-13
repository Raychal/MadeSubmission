package com.raychal.core.data.source.local

import com.raychal.core.data.source.local.entity.GameEntity
import com.raychal.core.data.source.local.room.GameDao
import com.raychal.core.utils.SortUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

class LocalDataSource(private val mGameDao: GameDao) {

    fun getAllGames(sort: String): Flow<List<GameEntity>> {
        val query = SortUtils.getSortedQueryGames(sort)
        return mGameDao.getGames(query)
    }

    fun getAllFavoriteGames(sort: String): Flow<List<GameEntity>> {
        val query = SortUtils.getSortedQueryFavoriteGames(sort)
        return mGameDao.getFavoriteGames(query)
    }

    fun getGameSearch(search: String): Flow<List<GameEntity>> {
        return mGameDao.getSearchMovies(search)
            .flowOn(Dispatchers.Default)
            .conflate()
    }

    suspend fun insertMovies(games: List<GameEntity>) = mGameDao.insertGame(games)

    fun setGameFavorite(game: GameEntity, newState: Boolean) {
        game.favorite = newState
        mGameDao.updateFavoriteGame(game)
    }
}