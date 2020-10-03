package com.nlpit.compose_weather_exercise.usecases.error_handling.state

import androidx.compose.runtime.Immutable

@Immutable
data class ErrorState(val message: String?)