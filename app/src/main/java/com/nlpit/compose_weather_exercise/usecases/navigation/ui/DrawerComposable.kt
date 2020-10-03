package com.nlpit.compose_weather_exercise.usecases.navigation.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.navigation.actions.NavigateActions
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState
import com.nlpit.compose_weather_exercise.usecases.places.actions.FetchLocationsAction

@Composable
fun DrawerComposable(closeDrawer: () -> Unit, state: ScreenState, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(start = 24.dp, top = 48.dp)) {
        state.screens.forEach {
            Spacer(Modifier.preferredHeight(24.dp))
            Text(
                modifier = Modifier.clickable(onClick = {
                    DI.dispatch(it.action)
                    closeDrawer()
                }),
                text = it.title,
                style = MaterialTheme.typography.h4
            )
        }
    }
}