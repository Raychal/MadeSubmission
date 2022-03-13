package com.raychal.core.data

import com.raychal.core.data.source.local.LocalDataSource
import com.raychal.core.data.source.remote.RemoteDataSource
import com.raychal.core.data.source.remote.network.ApiResponse
import com.raychal.core.data.source.remote.response.GameResponse
import com.raychal.core.domain.model.Game
import com.raychal.core.domain.repository.IGameAppRepository
import com.raychal.core.utils.AppExecutors
import com.raychal.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameAppRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameAppRepository {

    override fun getAllGames(sort: String): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGames(sort).map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> {
                return remoteDataSource.getGames()
            }

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val movieList = DataMapper.mapGameResponsetoEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlow()

    override fun getFavoriteGames(sort: String): Flow<List<Game>> {
        return localDataSource.getAllFavoriteGames(sort).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getSearchGames(search: String): Flow<List<Game>> {
        return localDataSource.getAllGames(search).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setGameFavorite(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setGameFavorite(gameEntity, state) }
    }
}