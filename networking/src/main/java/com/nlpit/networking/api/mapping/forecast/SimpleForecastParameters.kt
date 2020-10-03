package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleForecastParameters(
        @SerialName("temp") val temperature: Float?,
        @SerialName("pressure") val pressure: Float?,
        @SerialName("humidity") val humidity: Float?,
        @SerialName("temp_min") val minTemperature: Float?,
        @SerialName("temp_max") val maxTemperature: Float?
)