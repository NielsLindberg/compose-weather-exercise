package com.nlpit.compose_weather_exercise.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = deepOrange,
    primaryVariant = deepOrangeDark,
    secondary = brown,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.Black,
    onSecondary = whiteIsh,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun ComposeweatherexerciseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        LightColorPalette //DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}