package com.nlpit.compose_weather_exercise.usecases

import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.error_handling.reducer.ErrorStateReducer
import com.nlpit.compose_weather_exercise.usecases.navigation.reducer.NavigationReducer
import com.nlpit.compose_weather_exercise.usecases.places.reducer.PlacesReducer

val GlobalStateReducer: Reducer<GlobalState> = { old, action ->
    GlobalState(
        errorState = ErrorStateReducer(old.errorState, action),
        placesState = PlacesReducer(old.placesState, action),
        screenState = NavigationReducer(old.screenState, action)
    )
}