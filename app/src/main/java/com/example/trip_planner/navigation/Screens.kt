package com.example.trip_planner.navigation

sealed class Screens(val route: String){
    object LoginRoute : Screens(route = "Login")
    object ForgetPassRoute : Screens(route = "ForgetPass")
    object RegisterRoute : Screens(route = "Register")
    object HomeRoute : Screens(route = "Home")
    object AuthRoute : Screens(route = "Auth")
    object AppRoute : Screens(route = "App")
    object BookingRoute :Screens(route = "Booking")
    object AiRoute :Screens(route = "Ai")
    object ProfileRoute : Screens(route = "Profile")
    object FlightRoute : Screens(route = "Flight")
    object HotelRoute : Screens(route = "Hotel" )
    object VehicleRote : Screens(route = "Vehicle")
    object TrainRoute : Screens(route = "Train")
}