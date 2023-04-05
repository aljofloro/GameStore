package com.example.gamestore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun HomeFragment(modifier: Modifier = Modifier){
  Surface(modifier = Modifier.fillMaxSize(),
  color = MaterialTheme.colors.background){
    HomeScreen()
  }
}

@Preview(showBackground = true)
@Composable
fun FomeFragmentPreview(){
  GameStoreTheme {
    HomeFragment()
  }
}