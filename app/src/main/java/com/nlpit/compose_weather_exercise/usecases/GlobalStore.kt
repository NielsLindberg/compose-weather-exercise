package com.nlpit.compose_weather_exercise.usecases

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.nlpit.compose_weather_exercise.framework.redux.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DefaultStore<AppState: State>(
    initialState: AppState,
    private val reducer: Reducer<AppState>,
    private val middleware: List<Middleware<AppState>>
) : Store<AppState>, CoroutineScope {

    override val state: MutableState<AppState> = mutableStateOf(initialState)

    override fun dispatch(action: Action) {
        launch {
            val newAction = applyMiddleware(state.value, action)
            state.value = reducer(state.value, newAction)
        }
    }

    private fun applyMiddleware(state: AppState, action: Action): Action {
        return next(0)(state, action, ::dispatch)
    }

    private fun next(index: Int): Next<AppState> {
        if (index == middleware.size) {
            // Last link of the chain. It just returns the action as is.
            return { _, action, _ -> action }
        }
        return { state, action, dispatch  ->
            middleware[index].invoke(
                state,
                action,
                dispatch,
                next(index + 1)
            )
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}