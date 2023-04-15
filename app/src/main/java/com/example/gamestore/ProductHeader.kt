package com.example.gamestore

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun ProductHeader(
  modifier: Modifier = Modifier,
  name:String = "",
  imageUrl:String = "",
  releasedDate:String = ""
){
  ConstraintLayout(modifier = modifier) {
    val(
      photoAvatar,
      nameText,
      titleText
    ) = createRefs()

    Image(
      painter = rememberAsyncImagePainter(model = imageUrl,
      error = painterResource(id = R.drawable.ic_launcher_foreground)),
      contentDescription = name,
      modifier = Modifier
        .size(96.dp)
        .clip(CircleShape)
        .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
        .constrainAs(photoAvatar) {
          start.linkTo(parent.start)
          top.linkTo(parent.top)
          bottom.linkTo((parent.bottom))
        }
    )
    Text(
      text = name,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      fontSize = 20.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier
        .constrainAs(nameText){
          start.linkTo(photoAvatar.end,16.dp)
          top.linkTo(parent.top)
        }
    )
    Text(
      text = releasedDate,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      fontSize = 18.sp,
      fontWeight = FontWeight.Medium,
      modifier = Modifier.constrainAs(titleText){
        start.linkTo(photoAvatar.end,16.dp)
        top.linkTo(nameText.bottom,4.dp)
      }
    )

  }
}

@Preview(showBackground = true)
@Composable
fun ProductHeaderPreview(){
  GameStoreTheme {
    ProductHeader()
  }
}