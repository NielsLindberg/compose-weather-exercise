package com.nlpit.networking.api.mapping.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimpleForecastLocation(@SerialName("lat") val latitude: Double?,
                                  @SerialName("lon") val longitude: Double?)