package com.example.gamestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class HomeViewModel constructor(
  gamesRepository: GamesRepository = GamesRepositoryImpl()
): ViewModel() {
  val gamesListState: Flow<PagingData<Games>> =
    gamesRepository.getAllGames().cachedIn(viewModelScope)
}