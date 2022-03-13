package com.raychal.core.data.source.local.room

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.raychal.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @RawQuery(observedEntities = [GameEntity::class])
    fun getGames(query: SupportSQLiteQuery): Flow<List<GameEntity>>

    @Query("SELECT * FROM gameEntities WHERE name LIKE '%' || :search || '%'")
    fun getSearchMovies(search: String): Flow<List<GameEntity>>

    @RawQuery(observedEntities = [GameEntity::class])
    fun getFavoriteGames(query: SupportSQLiteQuery): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(games: List<GameEntity>)

    @Update
    fun updateFavoriteGame(game: GameEntity)
}