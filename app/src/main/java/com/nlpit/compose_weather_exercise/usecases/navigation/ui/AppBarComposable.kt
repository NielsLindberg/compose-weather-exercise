package com.nlpit.compose_weather_exercise.usecases.navigation.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.R
import com.nlpit.compose_weather_exercise.usecases.navigation.state.ScreenState

@Composable
fun AppBarComposable(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    screenState: ScreenState
) {
    TopAppBar(
        title = {
            Text(
                modifier = modifier,
                text = screenState.currentScreen.title,
                style = MaterialTheme.typography.h4,
                color = Color.White)
        }, modifier = modifier, navigationIcon = {
            IconButton(onClick = { openDrawer() }) {
                Image(
                    modifier = modifier,
                    asset = vectorResource(id = R.drawable.ic_baseline_menu_24)
                )
            }
        }, backgroundColor = MaterialTheme.colors.primary
    )
}