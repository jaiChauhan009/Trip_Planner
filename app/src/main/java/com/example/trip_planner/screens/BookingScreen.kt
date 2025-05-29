package com.example.trip_planner.screens


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trip_planner.navigation.Screens

data class BookingOption(val title: String)

@Composable
fun  BookingScreen(navController: NavController, modifier: Modifier = Modifier){
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text= "Register Screen", fontSize = 40.sp)

            val context = LocalContext.current
    val bookingOptions = listOf(
        BookingOption("Train"),
        BookingOption("Flight"),
        BookingOption("Hotel"),
        BookingOption("Vehicle"),
        BookingOption("Courier"),
        BookingOption("More")
    )

    var bookingHistory by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "Book Services",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.height(320.dp)
        ) {
            items(bookingOptions) { option ->
                BookingItem(option) {
                    when (option.title) {
                        "Train" -> navController.navigate(Screens.TrainRoute.route)
                        "Flight" -> navController.navigate(Screens.FlightRoute.route)
                        "Hotel" -> navController.navigate(Screens.HotelRoute.route)
                        "Vehicle" -> navController.navigate(Screens.VehicleRote.route)
                        "More" -> Toast.makeText(context, "More coming soon...", Toast.LENGTH_SHORT).show()
                    }
                    if (option.title != "More") {
                        bookingHistory = bookingHistory + "${option.title} booking at ${System.currentTimeMillis()}"
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text  = "Booking History",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(bookingHistory.reversed()) { record ->
                Text(
                    text = record,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
        Spacer(modifier.height(40.dp))
        Button(onClick = {
            navController.navigate(Screens.HomeRoute.route)
        }) {
            Text(text = "register (go login)", fontSize = 25.sp)
        }
    }
}

@Composable
fun BookingItem(option: BookingOption, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = option.title, fontSize = 18.sp)
        }
    }
}