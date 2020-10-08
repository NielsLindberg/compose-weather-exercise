package com.nlpit.compose_weather_exercise.usecases.forecast.reducer

import com.nlpit.compose_weather_exercise.framework.redux.Reducer
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.FetchForecastSuccessful
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.FetchForecastUnsuccessful
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.SelectDailyForecast
import com.nlpit.compose_weather_exercise.usecases.forecast.state.ForecastState

val ForecastReducer: Reducer<ForecastState> = { old, action ->
    when (action) {
        is FetchForecastSuccessful -> old.copy(forecast = action.forecast, errorMessage = null)
        is FetchForecastUnsuccessful -> old.copy(errorMessage = action.errorMessage)
        is SelectDailyForecast -> old.copy(forecast = old.forecast?.copy(selectedDaily = action.forecastDaily))
        else -> old
    }
}