package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleForecastWeather(
        @SerialName("id") val id: Int?,
        @SerialName("main") val name: String?,
        @SerialName("description") val description: String?,
        @SerialName("icon") val icon: String?
)