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
            modifier = modifier.fillMaxWidth().preferredHeight(75.dp).clickable(onClick = {
                DI.dispatch(action = FetchForecastAction(place.woeId))
                DI.dispatch(action = NavigateActions.ForecastScreen(place))
            }),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = modifier.fillMaxHeight().preferredWidth(75.dp),
                shape = MaterialTheme.shapes.small,
                backgroundColor = place.temperature.toColor(),
                gravity = Alignment.Center,
            ) {
                Text(
                    modifier = modifier,
                    style = MaterialTheme.typography.h5,
                    text = place.temperature.toString(),
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = modifier.preferredWidth(8.dp))
            Column(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
                Text(modifier = modifier, style = MaterialTheme.typography.h4, text = place.city)
                Text(modifier = modifier, style = MaterialTheme.typography.h6, text = place.country)
            }
        }
}