package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SimpleForecastCity (
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?,
    @SerialName("coord") val location: SimpleForecastLocation?,
    @SerialName("country") val countryCode: String?
)