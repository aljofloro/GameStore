package com.example.gamestore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
onClickToDetailScreen:(Int)->Unit ={}){
  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 96.dp)
    , modifier = modifier
    , verticalArrangement = Arrangement.spacedBy(16.dp)
    , horizontalArrangement = Arrangement.spacedBy(16.dp)){
    items(80){
      ProductCard(
        modifier = modifier.padding(16.dp),
        onClickProduct = { onClickToDetailScreen.invoke(1) })
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