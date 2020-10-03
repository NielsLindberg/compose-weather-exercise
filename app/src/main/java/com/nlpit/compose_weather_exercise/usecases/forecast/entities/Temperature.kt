package com.nlpit.compose_weather_exercise.usecases.forecast.entities

data class Temperature(val value: Int,
                       val unit: TemperatureUnit
) {
    override fun toString(): String {
        return "$value ${unit.postFix}"
    }
}

sealed class TemperatureUnit(val postFix: String) {
    object Celsius : TemperatureUnit(postFix = "°C")
}