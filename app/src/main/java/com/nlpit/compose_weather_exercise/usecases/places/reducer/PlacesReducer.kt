package com.nlpit.compose_weather_exercise.usecases.places.reducer

import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsSuccessful
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsUnsuccessful

val PlacesReducer: Reducer<PlacesState> = { old, action ->
    when (action) {
        is FetchLocationsSuccessful -> old.copy(places = action.places, errorMessage = null)
        is FetchLocationsUnsuccessful -> old.copy(errorMessage = action.errorMessage)
        else -> old
    }
}