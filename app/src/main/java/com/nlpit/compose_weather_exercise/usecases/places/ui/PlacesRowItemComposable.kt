package com.nlpit.compose_weather_exercise.usecases.places.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.FetchForecastAction
import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place
import com.nlpit.compose_weather_exercise.utils.ui.toColor

@Composable
fun PlacesRowItemComposable(modifier: Modifier = Modifier, place: Place) {
        Row(
            modifier = modifier.fillMaxWidth().clickable(onClick = {
                DI.dispatch(action = FetchForecastAction(place.woeId))
                DI.dispatch(action = NavigateActions.ForecastScreen(place))
            }),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = modifier.fillMaxHeight(),
                backgroundColor = place.temperature.toColor(),
            ) {
                Text(
                    modifier = modifier,
                    text = place.temperature.toString()
                )
            }
            Spacer(modifier = modifier)
            Column(modifier = modifier.fillMaxHeight()) {
                Text(modifier = modifier, text = place.city)
                Text(modifier = modifier, text = place.country)
            }
        }
}