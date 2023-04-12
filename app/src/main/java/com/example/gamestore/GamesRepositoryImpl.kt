package com.example.gamestore

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GamesRepositoryImpl constructor(
  private val gamesService: GameService = GameService.getInstance()
):GamesRepository {
  override fun getAllGames(): Flow<PagingData<Games>> = Pager(
    config = PagingConfig(
      pageSize = PAGE_SIZE,
      enablePlaceholders = true
    ),
    pagingSourceFactory = {
      GamePagingSource(
        response = { pageNext ->
          gamesService.getAllGames(
            page = pageNext,
            pageSize = PAGE_SIZE
          )
        }
      )
    }
  ).flow

  override fun getDetailGames(id: Int): Flow<Response<Games>> = flow {
    try{
      emit(Response.Loading)
      val responseApi = gamesService.getGamesDetail(id = id)
      emit(Response.Success(responseApi))
    }catch (e: Exception){
      emit(Response.Failure(e))
    }
  }.flowOn(Dispatchers.IO)
}