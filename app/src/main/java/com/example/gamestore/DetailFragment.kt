package com.example.gamestore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailFragment(
  modifier: Modifier = Modifier
) {
  Surface(modifier = modifier.fillMaxSize(),
  color = MaterialTheme.colors.background) {
    DetailScreen()
  }
}