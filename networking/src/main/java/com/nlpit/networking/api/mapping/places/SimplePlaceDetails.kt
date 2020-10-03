package com.nlpit.networking.api.mapping.places

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplePlaceDetails(
        @SerialName("type") val type: Int? = null,
        @SerialName("id") val id: Int? = null,
        @SerialName("country") val countryCode: String? = null,
        @SerialName("sunrise") val sunrise: Long? = null,
        @SerialName("sunset") val sunset: Long? = null
)