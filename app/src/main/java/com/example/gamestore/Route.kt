package com.example.gamestore

sealed class Route (val route:String) {
  object Home:Route("Home")
  object Detail:Route("Detail/{gamesId}"){
    fun createRoute(gamesId:Int) = "Detail/$gamesId"
  }
}