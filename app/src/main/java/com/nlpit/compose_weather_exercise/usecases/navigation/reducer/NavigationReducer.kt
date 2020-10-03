package com.nlpit.compose_weather_exercise.usecases.navigation.reducer

import androidx.compose.material.DrawerValue
import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.navigation.entities.Screen
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState

val NavigationReducer: Reducer<ScreenState> = { old, action ->
    when (action) {
        is NavigateActions.HomeScreen -> old.copy(currentScreen = Screen.Home)
        is NavigateActions.YoScreen -> old.copy(currentScreen = Screen.Yo)
        is NavigateActions.PlacesScreen -> old.copy(currentScreen = Screen.Places)
        else -> old
    }
}