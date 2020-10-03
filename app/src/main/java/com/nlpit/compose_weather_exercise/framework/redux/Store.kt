package com.nlpit.compose_weather_exercise.framework.redux

import androidx.compose.runtime.MutableState

interface Store<AppState: State> {
    fun dispatch(action: Action)
    val state: MutableState<AppState>
}