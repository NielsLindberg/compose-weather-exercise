package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleForecastGroup (
    @SerialName("cnt") val cnt: Int?,
    @SerialName("city") val city: SimpleForecastCity?,
    @SerialName("list") val forecasts: List<SimpleForecast>?
)