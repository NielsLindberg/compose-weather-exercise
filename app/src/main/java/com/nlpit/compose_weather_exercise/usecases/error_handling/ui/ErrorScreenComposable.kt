package com.nlpit.compose_weather_exercise.usecases.error_handling.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.R
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsAction

@Composable
fun ErrorScreenComposable(
    modifier: Modifier = Modifier,
    buttonTitle: String,
    errorMessage: String,
    action: () -> Unit
) {
    Column(modifier = modifier) {
        Image(asset = vectorResource(id = R.drawable.error_ic),
            modifier = Modifier.preferredSize(50.dp)
        )
        Text(text = errorMessage)
        Surface(
            color = MaterialTheme.colors.surface,
            elevation = 5.dp,
            modifier = modifier.clickable(onClick = {
                action.invoke()
            })
        ) {
            Text(text = buttonTitle)
        }
    }
}