package com.nlpit.compose_weather_exercise.framework.redux.middlewares.async

import com.nlpit.compose_weather_exercise.framework.redux.Action


open class AsyncAction(val asyncFun: suspend () -> Unit): Action()