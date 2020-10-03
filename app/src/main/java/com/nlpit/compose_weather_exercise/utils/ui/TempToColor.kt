package com.nlpit.compose_weather_exercise.utils.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.util.annotation.ColorInt
import com.nlpit.compose_weather_exercise.R
import com.nlpit.compose_weather_exercise.theme.*
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Temperature
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.TemperatureUnit

fun Temperature.toColor(): Color {
    return when (unit) {
        TemperatureUnit.Celsius -> {
            value.celsiusToColor()
        }
    }
}

fun Int.celsiusToColor() = when (this) {
    in Int.MIN_VALUE..-5 -> temperature1
    in -4..2 -> temperature2
    in 3..14 -> temperature3
    in 15..26 -> temperature4
    else -> temperature5
}