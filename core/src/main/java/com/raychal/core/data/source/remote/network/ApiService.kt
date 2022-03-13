package com.raychal.core.data.source.remote.network

import com.raychal.core.data.source.remote.response.ListDetailGameResponse
import com.raychal.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGames(
        @Query("api_key") key: String,
    ): ListGameResponse

    @GET("games/{id}")
    suspend fun getDetail(
        @Query("api_key") key: String
    ): ListDetailGameResponse

}