package com.example.trip_planner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.AuthRoute.route) {
        authGraph(navController)
        appGraph(navController)
        bookingGraph(navController)
    }
}