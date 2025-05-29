package com.example.trip_planner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trip_planner.navigation.Screens


@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen", fontSize = 40.sp)
        Spacer(modifier.height(40.dp))
        Button(onClick = {
            navController.navigate(Screens.HomeRoute.route)
        }) {
            Text(text = "Login(Go to home)", fontSize = 25.sp)
        }
        Spacer(modifier.height(40.dp))
        Button(onClick = {

            navController.navigate(Screens.ForgetPassRoute.route)
        }) {
            Text(text = "Forgot password", fontSize = 25.sp)
        }
        Spacer(modifier.height(40.dp))
        Button(onClick = {

            navController.navigate(Screens.RegisterRoute.route)
        }) {
            Text(text = "Register", fontSize = 25.sp)
        }

    }
}