package com.example.trip_planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.trip_planner.navigation.Nav
import com.example.trip_planner.navigation.Screens
import com.example.trip_planner.navigation.appGraph
import com.example.trip_planner.navigation.authGraph
import com.example.trip_planner.navigation.bookingGraph
import com.example.trip_planner.screens.HomeScreen
import com.example.trip_planner.ui.theme.Trip_PlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Trip_PlannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.AuthRoute.route
                    ) {
//                        authGraph(navController)
                        appGraph(navController)
                        bookingGraph(navController)
                    }
                    HomeScreen(navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

