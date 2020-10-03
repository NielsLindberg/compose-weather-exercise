package com.nlpit.compose_weather_exercise.usecases.places.reducer

import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsSuccessful
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState

val PlacesReducer: Reducer<PlacesState> = { old, action ->
    when (action) {
        is FetchLocationsSuccessful -> old.copy(places = action.places)
        else -> old
    }
}