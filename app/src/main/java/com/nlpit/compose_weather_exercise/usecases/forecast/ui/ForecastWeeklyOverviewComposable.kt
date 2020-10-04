package com.nlpit.compose_weather_exercise.usecases.forecast.ui

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.forecast.actions.SelectDailyForecast
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Forecast
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.ForecastDaily
import com.nlpit.compose_weather_exercise.utils.ui.dayOfWeek
import com.nlpit.compose_weather_exercise.utils.ui.longDate
import dev.chrisbanes.accompanist.coil.CoilImage
import timber.log.Timber

@Composable
fun ForecastWeeklyOverviewComposable(modifier: Modifier = Modifier, forecast: Forecast) {
        ScrollableColumn(modifier = modifier.fillMaxWidth(), isScrollEnabled = true) {
            forecast.dailyForecasts.forEach {
                ForecastWeeklyOverviewItemComposable(modifier = modifier, forecastDaily = it)
            }
        }
}

@Composable
fun ForecastWeeklyOverviewItemComposable(modifier: Modifier = Modifier, forecastDaily: ForecastDaily) {
    Row(
        modifier = modifier.fillMaxWidth().preferredHeight(75.dp).clickable(onClick = {
            DI.dispatch(SelectDailyForecast(forecastDaily = forecastDaily))
        }),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier.preferredWidth(110.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(modifier = modifier, text = forecastDaily.date.dayOfWeek(), style = MaterialTheme.typography.h6)
            Text(modifier = modifier, text = forecastDaily.date.longDate(), style = MaterialTheme.typography.subtitle1)
        }
        CoilImage(data =  forecastDaily.weatherImageUrl, modifier = modifier.size(75.dp))
        Column(modifier = modifier.preferredWidth(130.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(modifier = modifier, text = forecastDaily.weatherType, style = MaterialTheme.typography.h6)
            Text(modifier = modifier, text = forecastDaily.weatherSubType, style = MaterialTheme.typography.subtitle1)
        }
        Column(modifier = modifier.preferredWidth(50.dp), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.End) {
            Text(modifier = modifier, text = forecastDaily.maxTemperature.toString(), style = MaterialTheme.typography.h6)
            Text(modifier = modifier, text = forecastDaily.minTemperature.toString(), style = MaterialTheme.typography.h6,
                color = MaterialTheme.typography.h6.color.copy(alpha = 0.5f))
        }
    }
}