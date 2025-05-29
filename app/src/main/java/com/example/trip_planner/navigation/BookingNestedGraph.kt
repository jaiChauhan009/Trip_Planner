package com.example.trip_planner.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.trip_planner.screens.booking.FlightScreen
import com.example.trip_planner.screens.booking.HotelScreen
import com.example.trip_planner.screens.booking.TrainScreen
import com.example.trip_planner.screens.booking.VehicleScreen

fun NavGraphBuilder.bookingGraph(navController: NavController){

    navigation(startDestination = Screens.TrainRoute.route, route = Screens.BookingRoute.route){
        composable(route = Screens.TrainRoute.route) {
            TrainScreen(navController = navController)
        }
        composable(route = Screens.FlightRoute.route) {
            FlightScreen(navController = navController)
        }
        composable(route = Screens.HotelRoute.route) {
            HotelScreen(navController = navController)
        }
        composable(route = Screens.VehicleRote.route){
            VehicleScreen(navController = navController)
        }
    }
}