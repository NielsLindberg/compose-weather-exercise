package com.nlpit.compose_weather_exercise.usecases.navigation.ui

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nlpit.compose_weather_exercise.usecases.GlobalState
import com.nlpit.compose_weather_exercise.usecases.navigation.entities.Screen
import com.nlpit.compose_weather_exercise.usecases.places.ui.PlacesScreenComposable

@Composable
fun ScreenSwitchComposable(
    modifier: Modifier = Modifier,
    state: GlobalState
) {
    when (state.screenState.currentScreen) {
        Screen.Home -> Text("Home")
        Screen.Places -> PlacesScreenComposable(modifier = modifier, state = state.placesState)
        Screen.Yo -> Text("Yo")
    }
}