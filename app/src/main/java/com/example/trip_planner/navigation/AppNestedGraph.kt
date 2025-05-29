package com.example.trip_planner.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.trip_planner.screens.AiScreen
import com.example.trip_planner.screens.BookingScreen
import com.example.trip_planner.screens.HomeScreen
import com.example.trip_planner.screens.ProfileScreen

fun NavGraphBuilder.appGraph(navController: NavController){
    navigation(startDestination = Screens.HomeRoute.route, route = Screens.AppRoute.route){
        composable(route = Screens.HomeRoute.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.BookingRoute.route) {
            BookingScreen(navController = navController)
        }
        composable(route = Screens.AiRoute.route) {
            AiScreen(navController = navController)
        }
        composable(route = Screens.ProfileRoute.route){
            ProfileScreen(navController)
        }
    }
}