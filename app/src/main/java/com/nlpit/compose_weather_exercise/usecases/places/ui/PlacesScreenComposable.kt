package com.nlpit.compose_weather_exercise.usecases.places.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState
import com.nlpit.compose_weather_exercise.utils.ui.toColor

@Composable
fun PlacesScreenComposable(
    modifier: Modifier = Modifier,
    state: PlacesState
) {
    Column(modifier) {
        state.places.forEach {
            Row(modifier) {
                Text(it.city)
                Text(it.country)
                Text(modifier = modifier.background(
                   color = it.temperature.toColor(),
                ), text = it.temperature.toString())
                Text(it.weatherCode.toString())
            }
        }
    }
}