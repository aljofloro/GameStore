package com.example.gamestore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun DetailScreen (
  modifier: Modifier = Modifier,
  games: Games? = null
) {
  if(games == null)return
  val name = games.name ?:""
  val imageUrl = games.background_image ?:""
  val releasedDate = games.released ?:""
  val description= HtmlCompat
    .fromHtml(games.description ?:"",HtmlCompat.FROM_HTML_MODE_COMPACT)
    .toString()
  val listImageCarousel = mutableListOf<String>()
  games.background_image?.let{
    listImageCarousel.add(it)
  }
  games.background_image_additional?.let {
    listImageCarousel.add(it)
  }
  val scrollState = rememberScrollState()
  Column(
    modifier = modifier
      .fillMaxWidth()
      .verticalScroll(scrollState)) {
    ProductHeader(modifier = Modifier.padding(16.dp),
    imageUrl = imageUrl,
    name = name,
    releasedDate = releasedDate)
    ProductImageCarousel(modifier = Modifier
      .height(200.dp)
      .fillMaxWidth(),
    listImage = listImageCarousel)
    Text(
      text = description,
      fontSize = 12.sp,
      fontWeight = FontWeight.Medium,
      modifier = Modifier.padding(
        top = 16.dp,
        start = 16.dp,
        end = 16.dp
      )
    )
  }
}
@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
  GameStoreTheme {
    DetailScreen()
  }
}