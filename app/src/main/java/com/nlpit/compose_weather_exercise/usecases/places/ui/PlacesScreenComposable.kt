package com.nlpit.compose_weather_exercise.usecases.places.ui

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.unit.dp
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
        state.places.forEach {
            Spacer(Modifier.preferredHeight(8.dp))
            Row(modifier = modifier.fillMaxWidth()) {
                PlacesRowItemComposable(modifier = modifier, place = it)

            }

        }

    }
}
