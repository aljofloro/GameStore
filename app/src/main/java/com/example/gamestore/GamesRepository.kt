package com.example.gamestore

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
  fun getAllGames(): Flow<PagingData<Games>>
  fun getDetailGames(id:Int): Flow<Response<Games>>
}