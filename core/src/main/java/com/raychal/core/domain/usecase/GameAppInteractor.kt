package com.raychal.core.domain.usecase

import com.raychal.core.data.Resource
import com.raychal.core.domain.model.Game
import com.raychal.core.domain.repository.IGameAppRepository
import kotlinx.coroutines.flow.Flow

class GameAppInteractor(private val  iGameAppRepository: IGameAppRepository): GameAppUseCase {
    override fun getAllGames(sort: String): Flow<Resource<List<Game>>> =
        iGameAppRepository.getAllGames(sort)

    override fun getFavoriteGames(sort: String): Flow<List<Game>> =
        iGameAppRepository.getFavoriteGames(sort)

    override fun getSearchGames(search: String): Flow<List<Game>> =
        iGameAppRepository.getSearchGames(search)

    override fun setGameFavorite(game: Game, state: Boolean) =
        iGameAppRepository.setGameFavorite(game, state)

}