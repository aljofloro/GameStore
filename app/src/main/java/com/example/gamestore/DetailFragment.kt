package com.example.gamestore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetailFragment(
  modifier: Modifier = Modifier,
  gamesId:Int,
  detailViewModel: DetailViewModel = viewModel(),
) {
  fun launch(){
    detailViewModel.getDetailGames(gamesId)
  }
  launch()
  Surface(modifier = modifier.fillMaxSize(),
  color = MaterialTheme.colors.background) {
    when(val gamesResponse = detailViewModel.gamesState.value){
      is Response.Loading->{

      }
      is Response.Success->{
        DetailScreen(
          games = gamesResponse.data
        )
      }
      is Response.Failure->{
        Button(modifier = Modifier.fillMaxWidth(),
          onClick = {launch()}
        ) {
        Text("Error")
        }
      }
    }
  }
}