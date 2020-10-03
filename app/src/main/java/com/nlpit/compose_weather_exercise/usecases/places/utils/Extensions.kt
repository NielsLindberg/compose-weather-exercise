package com.nlpit.compose_weather_exercise.usecases.places.utils

import com.nlpit.compose_weather_exercise.usecases.places.entities.Place
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Temperature
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.TemperatureUnit
import com.nlpit.compose_weather_exercise.utils.ui.getCountryNameFromCountryCode
import com.nlpit.networking.api.mapping.places.SimplePlace
import com.nlpit.networking.api.mapping.places.SimplePlaceGroup

fun SimplePlaceGroup.asPlaces(): List<Place> {
    return places.orEmpty().mapNotNull { it.asPlace() }
}

fun SimplePlace.asPlace(): Place? {
    val woeId = id?.toString() ?: return null
    val weatherCode = weathers?.firstOrNull()?.id ?: return null
    val city = name ?: return null
    val country = getCountryNameFromCountryCode(details?.countryCode) ?: return null
    val temperature = parameters?.temperature?.toInt() ?: return null

    return Place(
        woeId = woeId,
        city = city,
        country = country,
        temperature = Temperature(
            value = temperature,
            unit = TemperatureUnit.Celsius),
        weatherCode = weatherCode)
}