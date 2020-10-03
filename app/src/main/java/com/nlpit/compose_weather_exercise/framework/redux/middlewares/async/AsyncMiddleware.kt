package com.nlpit.compose_weather_exercise.framework.redux.middlewares.async

import com.nlpit.compose_weather_exercise.framework.redux.*
import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AsyncMiddleware<AppState : State> : Middleware<AppState>, CoroutineScope {
    override fun invoke(
        state: AppState,
        action: Action,
        dispatch: Dispatch,
        next: Next<AppState>
    ): Action {
        when (action) {
            is AsyncAction -> {
                launch {
                    action.asyncFun.invoke()
                }
            }
            is NavigateActions.PlacesScreen -> dispatch(FetchLocationsAction())
        }
        return next(state, action, dispatch)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default
}
