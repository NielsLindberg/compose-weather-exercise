package com.nlpit.compose_weather_exercise.usecases.navigation.actions

import com.nlpit.compose_weather_exercise.framework.redux.Action
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place

sealed class NavigateActions: Action() {
    object HomeScreen: NavigateActions()
    object PlacesScreen: NavigateActions()
    class ForecastScreen(val place: Place): NavigateActions()
}