package com.nlpit.compose_weather_exercise.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//TODO 2: Create Color Palette
private val LightColorPalette = lightColors(
//    primary = deepOrange,
//    primaryVariant = ,
//    secondary = ,
//    background = ,
//    surface = ,
//    onPrimary = ,
//    onSecondary = ,
//    onBackground = ,
//    onSurface = ,
)

@Composable
fun ComposeweatherexerciseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        content = content,
        colors = LightColorPalette,
        typography = typography,
        shapes = shapes)
}