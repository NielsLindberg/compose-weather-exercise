package com.nlpit.compose_weather_exercise.usecases.navigation.actions

import com.nlpit.compose_weather_exercise.framework.redux.Action

sealed class NavigateActions: Action() {
    object HomeScreen: NavigateActions()
    object PlacesScreen: NavigateActions()
    object YoScreen: NavigateActions()
}