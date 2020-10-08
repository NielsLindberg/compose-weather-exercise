package com.nlpit.compose_weather_exercise.usecases.forecast.state

import androidx.compose.runtime.Immutable
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Forecast

@Immutable
data class ForecastState(
    val forecast: Forecast? = null,
    val errorMessage: String? = null
)