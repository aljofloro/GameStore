package com.example.gamestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gamestore.ui.theme.GameStoreTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GameStoreTheme {
        GameStoreAppScreen()
      }
    }
  }
}
@Composable
fun GameStoreAppScreen(){
  val navController = rememberNavController()
  NavHost(navController = navController
    , startDestination = Route.Home.route){
    composable(route = Route.Home.route){
      HomeFragment(onClickToDetailScreen = { gamesId ->
        navController.navigate(Route.Detail.createRoute(gamesId))
      })
    }
    composable(route = Route.Detail.route,
      arguments = listOf(navArgument("gamesId"){type = NavType.IntType})){
      val gamesId = it.arguments?.getInt("gamesId")
      requireNotNull(gamesId){"gamesId should exist"}
      DetailFragment(gamesId = gamesId)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GameStoreAppScreenPreview(){
  GameStoreTheme {
    GameStoreAppScreen()
  }
}