package com.example.gamestore

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
  companion object{
    val KEY_API = "05bfc70b960d4c579d7fb4e5579d1acd"

  }

  @GET("games")
  suspend fun getAllGames(
    @Query("key") key : String = KEY_API,
    @Query("page") page:Int,
    @Query("page_size") pageSize:Int): GamesResponse

  @GET("games/{id}")
  suspend fun getGamesDetail(
    @Path("id") id:Int,
    @Query("key") key : String = KEY_API
  ): Games


}