package com.nlpit.compose_weather_exercise.usecases.forecast.ui

import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.ForecastDaily
import com.nlpit.compose_weather_exercise.utils.ui.dayOfWeek
import com.nlpit.compose_weather_exercise.utils.ui.hourMinute
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ForecastIntraDayComposable(
    modifier: Modifier = Modifier,
    forecastDaily: ForecastDaily
    ) {
    Column(modifier.fillMaxWidth()) {
        Row(modifier = modifier.fillMaxWidth()) {
            Text(modifier = modifier, text = forecastDaily.date.dayOfWeek())
        }
        ScrollableRow(modifier = modifier.fillMaxWidth()) {
            forecastDaily.observations.forEach {
                Column(modifier = modifier.fillMaxHeight()) {
                    Text(modifier = modifier, text = it.temperature.toString())
                    CoilImage(data =  it.weatherImageUrl, modifier = modifier.size(50.dp))
                    Text(modifier = modifier, text = it.date.hourMinute())
                }
            }
        }
    }
}