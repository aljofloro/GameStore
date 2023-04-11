package com.example.gamestore

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamestore.ui.theme.GameStoreTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(
  modifier: Modifier = Modifier,
  onClickProduct: () -> Unit = {}
){
  Card(onClick = onClickProduct) {
    Column(modifier = modifier,
      horizontalAlignment = Alignment.CenterHorizontally) {
      Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier
          .size(40.dp)
          .clip(CircleShape)
          .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
      )
      Text(
        text = stringResource(R.string.productName),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = stringResource(R.string.productDescription),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontSize = 8.sp,
        fontWeight = FontWeight.Medium
      )
    }
  }

}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview(){
  GameStoreTheme{
    ProductCard()
  }
}