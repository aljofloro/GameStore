package com.example.gamestore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.gamestore.ui.theme.GameStoreTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductImageCarousel(
  modifier: Modifier = Modifier,
  listImage: List<String> = listOf()
){
  val state = rememberPagerState()
  HorizontalPager(
    state = state,
    pageCount = listImage.size,
    modifier = modifier,
  ) {pagerScope->
    val imagePainter = rememberAsyncImagePainter(
      model = listImage[pagerScope],
      error = painterResource(id = R.drawable.ic_launcher_foreground))
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painter = imagePainter,
        contentDescription = listImage[pagerScope],
        modifier = Modifier
          .padding(start = 8.dp, end = 8.dp)
          .clip(RoundedCornerShape(10.dp))
          .fillMaxSize(),
        contentScale = ContentScale.Crop
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ProductImagePreview(){
  GameStoreTheme {
    ProductImageCarousel()
  }
}