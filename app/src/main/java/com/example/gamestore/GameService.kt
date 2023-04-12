package com.example.gamestore

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
  companion object{
    val KEY_API = "05bfc70b960d4c579d7fb4e5579d1acd"
    private var  retrofitService: GameService? = null
    fun getInstance():GameService{
      if(retrofitService == null){
        val client = OkHttpClient
          .Builder()
          .addInterceptor(
            HttpLoggingInterceptor()
              .setLevel(HttpLoggingInterceptor.Level.BODY)
          ).build()
        val retrofit = Retrofit.Builder()
          .baseUrl("https://api.rawg.io/api/")
          .addConverterFactory(GsonConverterFactory.create())
          .client(client)
          .build()
        retrofitService = retrofit.create(GameService::class.java)
      }
      return retrofitService!!
    }
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