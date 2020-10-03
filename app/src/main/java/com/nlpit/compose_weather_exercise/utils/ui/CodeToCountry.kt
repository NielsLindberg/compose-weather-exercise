package com.nlpit.compose_weather_exercise.utils.ui

import java.util.*

fun getCountryNameFromCountryCode(countryCode: String?): String? {
    val code = countryCode ?: return null
    return Locale("", code).displayCountry
}