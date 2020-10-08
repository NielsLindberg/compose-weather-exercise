package com.nlpit.compose_weather_exercise.usecases.forecast.ui

import com.nlpit.compose_weather_exercise.usecases.forecast.state.ForecastState
import com.nlpit.compose_weather_exercise.usecases.places.ui.PlacesRowItemComposable

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.error_handling.ui.ErrorScreenComposable
import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsAction
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState
import com.nlpit.compose_weather_exercise.utils.ui.toColor

@Composable
fun ForecastScreenComposable(
    modifier: Modifier = Modifier,
    state: ForecastState
) {
    if(state.errorMessage == null) {
        state.forecast?.let { forecast ->
            ScrollableColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.Top,
                reverseScrollDirection = false,
                isScrollEnabled = true,
                contentPadding = PaddingValues(8.dp)
            ) {
                Spacer(modifier.preferredHeight(5.dp))
                ForecastIntraDayComposable(modifier = modifier, forecastDaily = forecast.selectedDaily)
                Spacer(modifier.preferredHeight(10.dp))
                ForecastWeeklyOverviewComposable(forecast = forecast)
            }
        }
    } else {
        ErrorScreenComposable(
            modifier = modifier,
            buttonTitle = "Go Back to Places",
            errorMessage = state.errorMessage,
            action = {
                DI.dispatch(NavigateActions.PlacesScreen)
            }
        )
    }
}
