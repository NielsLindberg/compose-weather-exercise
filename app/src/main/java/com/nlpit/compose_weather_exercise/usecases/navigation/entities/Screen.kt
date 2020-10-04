package com.nlpit.compose_weather_exercise.usecases.navigation.entities

import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place

sealed class Screen(val index: Int, val title: String, val action: NavigateActions) {
    object Home : Screen(0, "Home", NavigateActions.HomeScreen)
    object Places : Screen(1, "Places", NavigateActions.PlacesScreen)
    class Forecast(val place: Place) : Screen(2, place.city, NavigateActions.ForecastScreen(place))
}