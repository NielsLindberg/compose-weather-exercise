package com.nlpit.compose_weather_exercise.usecases.places.state

import androidx.compose.runtime.Immutable
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place
import com.nlpit.networking.api.mapping.places.SimplePlaceGroup

@Immutable
data class PlacesState(
    val places: List<Place> = emptyList(),
    val errorMessage: String? = null
)