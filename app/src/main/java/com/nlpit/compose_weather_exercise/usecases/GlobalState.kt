package com.nlpit.compose_weather_exercise.usecases

import androidx.compose.runtime.Immutable
import com.nlpit.compose_weather_exercise.framework.redux.State
import com.nlpit.compose_weather_exercise.usecases.error_handling.state.ErrorState
import com.nlpit.compose_weather_exercise.usecases.forecast.state.ForecastState
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState

@Immutable
data class GlobalState(
    val errorState: ErrorState,
    val placesState: PlacesState,
    val forecastState: ForecastState,
    val screenState: ScreenState
): State

