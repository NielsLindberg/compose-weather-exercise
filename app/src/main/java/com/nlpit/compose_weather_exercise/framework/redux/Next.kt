package com.nlpit.compose_weather_exercise.framework.redux

typealias Next<AppState> = (AppState, Action, Dispatch) -> Action