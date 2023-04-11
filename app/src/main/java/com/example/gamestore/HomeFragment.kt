package com.example.gamestore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun HomeFragment(modifier: Modifier = Modifier,
                 onClickToDetailScreen:(Int)->Unit ={}){
  Surface(modifier = Modifier.fillMaxSize(),
  color = MaterialTheme.colors.background){
    HomeScreen(modifier = modifier.padding(horizontal=16.dp),
    onClickToDetailScreen = onClickToDetailScreen)
  }
}

@Preview(showBackground = true)
@Composable
fun FomeFragmentPreview(){
  GameStoreTheme {
    HomeFragment()
  }
}