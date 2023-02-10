package com.example.rickandmorty.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.ui.home.HomeScreen

@Composable
fun RickAndMortyNavGraph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail:(Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    starDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController ,
        startDestination = starDestination,
        modifier = modifier ){
        composable(route = Screen.Home.route){
            HomeScreen(
                onItemClicked = {navigateToDetail(it)}
            )
        }
    }
}