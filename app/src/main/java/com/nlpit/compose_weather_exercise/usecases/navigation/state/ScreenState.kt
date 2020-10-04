package com.nlpit.compose_weather_exercise.usecases.navigation.state

import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.runtime.Immutable
import com.nlpit.compose_weather_exercise.usecases.navigation.entities.Screen

@Immutable
data class ScreenState(
    val currentScreen: Screen = Screen.Home,
    val drawer: List<Screen> = listOf(Screen.Home, Screen.Places)
)