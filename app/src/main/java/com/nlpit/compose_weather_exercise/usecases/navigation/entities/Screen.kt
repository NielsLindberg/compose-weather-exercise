package com.nlpit.compose_weather_exercise.usecases.navigation.entities

import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions

sealed class Screen(val index: Int, val title: String, val action: NavigateActions) {
    object Home : Screen(0, "Home", NavigateActions.HomeScreen)
    object Places : Screen(1, "Places", NavigateActions.PlacesScreen)
    object Yo : Screen(2, "Yo", NavigateActions.YoScreen)
}