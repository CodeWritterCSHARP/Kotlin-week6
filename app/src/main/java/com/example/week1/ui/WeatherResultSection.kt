package com.example.week1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week1.data.model.WeatherResponse
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card

@Composable
fun WeatherResultSection(weather: WeatherResponse) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = weather.name, style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Lämpötila: ${weather.main.temp} °C", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Kuvaus: ${weather.weather.firstOrNull()?.description ?: ""}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}