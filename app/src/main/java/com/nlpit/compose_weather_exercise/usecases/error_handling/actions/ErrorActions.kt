package com.nlpit.compose_weather_exercise.usecases.error_handling.actions

import com.nlpit.compose_weather_exercise.framework.redux.Action

open class ErrorActions(errorMessage: String): Action(errorMessage)