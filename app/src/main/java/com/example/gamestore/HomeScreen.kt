package com.example.gamestore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
onClickToDetailScreen:(Int)->Unit ={},
gamesList:LazyPagingItems<Games>? = null){
  if(gamesList == null) return
  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 96.dp)
    , modifier = modifier
    , verticalArrangement = Arrangement.spacedBy(16.dp)
    , horizontalArrangement = Arrangement.spacedBy(16.dp)){
    items(gamesList.itemCount){ index ->
      gamesList[index].let{games ->
        val id= games?.id
        val name = games?.name?:""
        val imageUrl = games?.background_image?:""
        val releasedDate = games?.released?:""
        ProductCard(
          modifier = modifier.padding(8.dp),
          name = name,
          imageUrl = imageUrl,
          releasedDate = releasedDate,
          onClickProduct = {
          id?.let{
            onClickToDetailScreen.invoke(it)
          }})
      }
    }
    gamesList.apply{
      item(span = { GridItemSpan(maxLineSpan) }){
        when{
          loadState.refresh is LoadState.Loading||loadState.append is LoadState.Loading->{

          }
          loadState.refresh is LoadState.Error||loadState.append is LoadState.Error->{

          }
        }
      }
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