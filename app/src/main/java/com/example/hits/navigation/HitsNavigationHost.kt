package com.example.hits.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType


import com.example.hits.screens.detail.DetailScreen
import com.example.hits.screens.home.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hits.screens.home.MainScreenViewModel


@Composable
fun HitsNavigationHost(navController: NavHostController, viewModel: MainScreenViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.name
    ) {
        composable(Screens.MainScreen.name) {
            //val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            MainScreen(navController,viewModel)
        }
        composable(Screens.DetailScreen.name + "/{hit}",
            arguments = listOf(navArgument(name ="hit") {type = NavType.StringType})) {
            DetailScreen(navController, it.arguments?.getString("hit"))
        }

    }
}