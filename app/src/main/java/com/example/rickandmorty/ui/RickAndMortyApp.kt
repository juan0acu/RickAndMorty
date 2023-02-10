package com.example.rickandmorty.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.ui.theme.RickandMortyTheme

@Composable
fun RickAndMortyApp() {
    RickandMortyTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            RickAndMortyActions(navController)
        }
        RickAndMortyNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigationToDetail
        )
    }
}