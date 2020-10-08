package com.nlpit.compose_weather_exercise.usecases.places.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.Text
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.R
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.error_handling.ui.ErrorScreenComposable
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.SelectDailyForecast
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsAction
import com.nlpit.compose_weather_exercise.usecases.places.state.PlacesState
import com.nlpit.compose_weather_exercise.utils.ui.toColor

@Composable
fun PlacesScreenComposable(
    modifier: Modifier = Modifier,
    state: PlacesState
) {
    ScrollableColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        reverseScrollDirection = false,
        isScrollEnabled = true,
        contentPadding = PaddingValues(8.dp)
    ) {
        if (state.errorMessage == null) {
            state.places.forEach {
                Spacer(Modifier.preferredHeight(8.dp))
                Row(modifier = modifier.fillMaxWidth()) {
                    PlacesRowItemComposable(modifier = modifier, place = it)

                }
            }
        } else {
            ErrorScreenComposable(
                modifier = modifier,
                buttonTitle = "Retry",
                errorMessage = state.errorMessage,
                action = {
                    DI.dispatch(FetchLocationsAction())
                }
            )
        }
    }
}
