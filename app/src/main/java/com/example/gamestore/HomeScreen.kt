package com.example.gamestore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 96.dp)
    , modifier = modifier
    , verticalArrangement = Arrangement.spacedBy(16.dp)
    , horizontalArrangement = Arrangement.spacedBy(16.dp)){
    items(80){
      ProductCard()
    }
  }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
  GameStoreTheme {
    ProductHeader()
  }
}