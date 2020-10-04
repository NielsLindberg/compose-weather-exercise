package com.nlpit.compose_weather_exercise.usecases.forecast.entities

import com.nlpit.compose_weather_exercise.utils.ui.getCountryNameFromCountryCode
import com.nlpit.compose_weather_exercise.utils.ui.longDate
import com.nlpit.compose_weather_exercise.utils.ui.unixToDate
import com.nlpit.networking.api.mapping.forecast.SimpleForecast
import com.nlpit.networking.api.mapping.forecast.SimpleForecastGroup

fun SimpleForecastGroup.asForecast(): Forecast? {
    val woeId = city?.id?.toString() ?: return null
    val cityName = city?.name ?: return null
    val country = getCountryNameFromCountryCode(city?.countryCode) ?: return null
    val observations = forecasts.orEmpty().mapNotNull { it.asForecastObservation() }
    val dailyForecasts = groupForecastDaily(observations) ?: return null

    return Forecast(
        woeId = woeId,
        city = cityName,
        country = country,
        dailyForecasts = dailyForecasts,
        selectedDaily = dailyForecasts.first()
    )
}

fun SimpleForecast.asForecastObservation(): ForecastObservation? {

    val date = unixToDate(date) ?: return null
    val temperature = parameters?.temperature?.toInt() ?: return null
    val weatherImage = weather?.firstOrNull()?.icon ?: return null
    val weatherType = weather?.firstOrNull()?.name ?: return null
    val weatherSubType = weather?.firstOrNull()?.description ?: return null

    return ForecastObservation(
        date = date,
        temperature = Temperature(
            value = temperature,
            unit = TemperatureUnit.Celsius),
        weatherImage = weatherImage,
        weatherType = weatherType,
        weatherSubType = weatherSubType
    )
}

fun groupForecastDaily(observations: List<ForecastObservation>): List<ForecastDaily>? {
    // Probably easier to use the daily API endpoint but its behind a paywall.
    return observations.groupBy { it.date.longDate() }.mapNotNull { groups ->
        with(groups.value) {
            val maxFreqWeatherType = groupBy{ obs -> obs.weatherType }.maxBy { it.value.size }?.value?.firstOrNull()
            val maxFreqWeatherSubType = groupBy{ obs -> obs.weatherSubType }.maxBy { it.value.size }?.value?.firstOrNull()
            ForecastDaily(
                date = groups.value.first().date,
                minTemperature = Temperature(
                    value = minByOrNull { obs -> obs.temperature.value }
                        ?.temperature?.value ?: -99,
                    unit = TemperatureUnit.Celsius
                ),
                maxTemperature = Temperature(
                    value = maxByOrNull { obs -> obs.temperature.value }
                        ?.temperature?.value ?: 99,
                    unit = TemperatureUnit.Celsius
                ),
                weatherImage = maxFreqWeatherSubType?.weatherImage ?: "N/A",
                weatherType = maxFreqWeatherType?.weatherType ?: "N/A",
                weatherSubType = maxFreqWeatherSubType?.weatherSubType ?: "N/A",
                observations = this
            )
        }

    }
}