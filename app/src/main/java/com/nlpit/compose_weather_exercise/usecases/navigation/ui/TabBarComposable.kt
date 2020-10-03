package com.nlpit.compose_weather_exercise.usecases.navigation.ui

import androidx.compose.foundation.*

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.R
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState

@Composable
fun TabBar(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    screenState: ScreenState
) {
    Row(modifier) {
        // Separate Row as the children shouldn't have the padding
        Row(Modifier.padding(top = 8.dp, start = 8.dp)) {
            Image(
                modifier = Modifier.padding(top = 8.dp).clickable(onClick = { openDrawer() }),
                asset = vectorResource(id = R.drawable.ic_menu)
            )
        }
        Divider()
        Text(modifier = Modifier, text = screenState.currentScreen.title)
    }
}