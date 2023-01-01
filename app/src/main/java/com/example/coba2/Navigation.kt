package com.example.coba2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object SecondaryScreen : Screen("secondary_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            Counter(navController = navController)
        }

        composable(route = Screen.SecondaryScreen.route) {
            SecondScreen(navController = navController)
        }
    }
}
