package com.example.hits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.hits.screens.home.MainScreenViewModel

@Composable
fun HitsNavigaton(viewModel: MainScreenViewModel?) {
    val navController = rememberNavController()
    if (viewModel != null) {
        HitsNavigationHost(navController,viewModel)
    }

}