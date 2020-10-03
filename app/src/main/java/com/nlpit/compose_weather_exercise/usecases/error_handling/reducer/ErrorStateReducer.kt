package com.nlpit.compose_weather_exercise.usecases.error_handling.reducer

import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.error_handling.state.ErrorState

val ErrorStateReducer: Reducer<ErrorState> = { old, action ->
    when (action) {
        //is CounterActions.GeneralError -> ErrorState(message = action.error.message)
        else -> old
    }
}