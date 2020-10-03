package com.nlpit.compose_weather_exercise.usecases

import com.nlpit.networking.api.initHttpClient
import com.nlpit.networking.api.initWeatherAPI
import com.nlpit.compose_weather_exercise.framework.redux.Action
import com.nlpit.compose_weather_exercise.framework.redux.middlewares.async.AsyncMiddleware
import com.nlpit.compose_weather_exercise.framework.redux.middlewares.logger.LoggerMiddleware
import com.nlpit.compose_weather_exercise.usecases.error_handling.state.ErrorState
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState

object DI {

    val store = DefaultStore(
        initialState = GlobalState(
            errorState = ErrorState("init"),
            placesState = PlacesState(),
            screenState = ScreenState()
        ),
        reducer = GlobalStateReducer,
        middleware = listOf(AsyncMiddleware(), LoggerMiddleware())
    )
    fun dispatch(action: Action) = store.dispatch(action)

    val woeIds = listOf(
        "2643743",
        "2950159",
        "3128760",
        "2267057",
        "2964574",
        "2618425",
        "524901",
        "5128581",
        "5375480",
        "2147714",
        "292223",
        "2988507")

    private val apiKey = "a428b773470cf1f1888d7ca0aaea1751"
    private val httpClient by lazy { initHttpClient(apiKey) }
    val weatherAPI by lazy { initWeatherAPI(httpClient) }
}