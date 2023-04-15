package com.example.gamestore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailViewModel constructor(
  private val gamesRepository: GamesRepository = GamesRepositoryImpl()
):ViewModel() {
  private val _gamesState = mutableStateOf<Response<Games>>(Response.Success(null))
  val gamesState: State<Response<Games>> = _gamesState

  fun getDetailGames(id:Int){
    viewModelScope.launch {
      gamesRepository.getDetailGames(id).collect{
        _gamesState.value = it
      }
    }
  }
}