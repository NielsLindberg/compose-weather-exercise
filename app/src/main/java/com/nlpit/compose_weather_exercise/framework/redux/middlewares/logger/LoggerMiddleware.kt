package com.nlpit.compose_weather_exercise.framework.redux.middlewares.logger

import com.nlpit.compose_weather_exercise.framework.redux.*
import timber.log.Timber

class LoggerMiddleware<AppState : State> : Middleware<AppState> {
    override fun invoke(
        state: AppState,
        action: Action,
        dispatch: Dispatch,
        next: Next<AppState>
    ): Action {
        Timber.d("$action")
        return next(state, action, dispatch)
    }
}