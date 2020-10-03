package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleForecast(
        @SerialName("dt") val date: Long?,
        @SerialName("main") val parameters: SimpleForecastParameters?,
        @SerialName("weather") val weather: List<SimpleForecastWeather>?
)
