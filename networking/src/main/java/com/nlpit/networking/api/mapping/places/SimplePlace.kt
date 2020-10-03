package com.nlpit.networking.api.mapping.places

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplePlace(
    @SerialName("coord") val location: Location? = null,
    @SerialName("sys") val details: SimplePlaceDetails? = null,
    @SerialName("main") val parameters: SimplePlaceParameters? = null,
    @SerialName("weather") val weathers: List<SimplePlaceWeather>? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null
)