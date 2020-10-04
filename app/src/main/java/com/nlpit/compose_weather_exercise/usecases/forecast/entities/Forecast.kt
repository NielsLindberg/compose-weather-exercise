package com.nlpit.compose_weather_exercise.usecases.forecast.entities

import java.util.*

data class Forecast(
        val woeId: String,
        val city: String,
        val country: String,
        val dailyForecasts: List<ForecastDaily>,
        val selectedDaily: ForecastDaily
)

data class ForecastDaily(
        val date: Date,
        val maxTemperature: Temperature,
        val minTemperature: Temperature,
        val weatherType: String,
        val weatherImage: String,
        val weatherSubType: String,
        val observations: List<ForecastObservation>
) {
        val weatherImageUrl get() = "https://openweathermap.org/img/wn/$weatherImage@2x.png"

}

data class ForecastObservation(
        val date: Date,
        val temperature: Temperature,
        val weatherImage: String,
        val weatherType: String,
        val weatherSubType: String
) {
        val weatherImageUrl get() = "https://openweathermap.org/img/wn/$weatherImage@2x.png"
}

