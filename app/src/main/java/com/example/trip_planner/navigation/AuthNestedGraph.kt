package com.example.trip_planner.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.trip_planner.screens.ForgetPassScreen
import com.example.trip_planner.screens.LoginScreen
import com.example.trip_planner.screens.RegisterScreen

fun NavGraphBuilder.authGraph(navController: NavController){

    navigation(startDestination = Screens.LoginRoute.route, route = Screens.AuthRoute.route){
        composable(route = Screens.LoginRoute.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.RegisterRoute.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.ForgetPassRoute.route) {
            ForgetPassScreen(navController = navController)
        }
    }
}