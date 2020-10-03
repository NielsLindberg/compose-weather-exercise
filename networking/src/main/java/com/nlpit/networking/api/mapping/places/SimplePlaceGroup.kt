package com.nlpit.networking.api.mapping.places

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplePlaceGroup(
        @SerialName("cnt") val count: Int? = null,
        @SerialName("list") val places: List<SimplePlace>? = null
)