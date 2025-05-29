package com.example.trip_planner.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trip_planner.navigation.Screens



data class AiInteraction(val input: String, val output: String)

@Composable
fun  AiScreen(navController: NavController, modifier: Modifier = Modifier){
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var history by remember { mutableStateOf(listOf<AiInteraction>()) }
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text= "Register Screen", fontSize = 40.sp)
        Spacer(modifier.height(40.dp))

        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Ask something...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (searchQuery.text.isNotBlank()) {
                    // Simulate AI response (replace with real logic)
                    val fakeOutput = "Response to: ${searchQuery.text}"
                    history = listOf(AiInteraction(searchQuery.text, fakeOutput)) + history
                    searchQuery = TextFieldValue("")
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ask")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // History
        Text("Recent Interactions", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))

        LazyColumn {
            items(history) { interaction ->
                AiHistoryItem(interaction)
                Divider()
            }
        }
        Button(onClick = {
            navController.navigate(Screens.HomeRoute.route)
        }) {
            Text(text = "register (go login)", fontSize = 25.sp)
        }
    }
}


@Composable
fun AiHistoryItem(interaction: AiInteraction) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text("Input: ${interaction.input}", style = MaterialTheme.typography.bodyLarge)
        Text("Output: ${interaction.output}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp))
    }
}