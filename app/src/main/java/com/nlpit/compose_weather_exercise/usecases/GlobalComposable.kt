package com.nlpit.compose_weather_exercise.usecases

import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.nlpit.compose_weather_exercise.theme.ComposeweatherexerciseTheme
import com.nlpit.compose_weather_exercise.usecases.navigation.entities.Screen
import com.nlpit.compose_weather_exercise.usecases.navigation.ui.DrawerComposable
import com.nlpit.compose_weather_exercise.usecases.navigation.ui.ScreenSwitchComposable
import com.nlpit.compose_weather_exercise.usecases.navigation.ui.TabBar

@Composable
fun GlobalComposable(state: MutableState<GlobalState>) {
    ComposeweatherexerciseTheme {
        WeatherContent(state.value)
    }
}


@Composable
private fun WeatherContent(
    state: GlobalState,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(
        modifier = modifier,
        scaffoldState = rememberScaffoldState(drawerState = drawerState),
        drawerContent = {
            DrawerComposable(
                closeDrawer = { drawerState.close() },
                state = state.screenState,
                modifier = modifier
            )
        },
        topBar = {
            TabBar(
                openDrawer = { drawerState.open() },
                modifier = modifier,
                screenState = state.screenState
            )
        },
        bodyContent = {
            ScreenSwitchComposable(modifier = modifier, state = state)
        }
    )
}