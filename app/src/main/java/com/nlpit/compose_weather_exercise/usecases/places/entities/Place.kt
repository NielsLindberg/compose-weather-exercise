package com.nlpit.compose_weather_exercise.usecases.places.entities

import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Temperature

data class Place(val woeId: String,
                 val city: String,
                 val country: String,
                 val temperature: Temperature,
                 val weatherCode: Int)