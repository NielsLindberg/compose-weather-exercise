package com.nlpit.networking.api.mapping.places

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(@SerialName("lat") val latitude: Double? = null,
                    @SerialName("lon") val longitude: Double? = null)