package com.nlpit.compose_weather_exercise.usecases.forecast.actions


import com.nlpit.compose_weather_exercise.framework.redux.Action
import com.nlpit.compose_weather_exercise.framework.redux.middlewares.async.AsyncAction
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.error_handling.actions.ErrorActions
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.Forecast
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.ForecastDaily
import com.nlpit.compose_weather_exercise.usecases.forecast.entities.asForecast
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place
import com.nlpit.networking.api.mapping.forecast.SimpleForecastGroup
import com.nlpit.networking.api.mapping.places.SimplePlaceGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchForecastUnsuccessful(errorMessage: String) : ErrorActions(errorMessage)
class FetchForecastSuccessful(val forecast: Forecast) : Action(forecast)
class SelectDailyForecast(val forecastDaily: ForecastDaily) : Action(forecastDaily)

class FetchForecastAction(id: String) : AsyncAction(
    asyncFun = suspend {
        val ids = DI.woeIds.joinToString(separator = ",")
        DI.weatherAPI.forecastQuery(id = id)
            .enqueue(object : Callback<SimpleForecastGroup> {
                override fun onResponse(
                    call: Call<SimpleForecastGroup>,
                    response: Response<SimpleForecastGroup>
                ) {
                    if (!response.isSuccessful) {
                        DI.dispatch(FetchForecastUnsuccessful(errorMessage = response.message()))
                    }

                    val result = response.body()
                    if (result == null) {
                        DI.dispatch(FetchForecastUnsuccessful(errorMessage = "Response has no body"))
                    }

                    result?.let { forecastGroup ->
                        forecastGroup.asForecast()?.let {
                            DI.dispatch(FetchForecastSuccessful(it))
                        } ?: run {
                            DI.dispatch(FetchForecastUnsuccessful(errorMessage = "ForecastGroup -> Forecast failed"))
                        }

                    }
                }

                override fun onFailure(call: Call<SimpleForecastGroup>, t: Throwable) {
                    DI.dispatch(FetchForecastUnsuccessful(errorMessage = t.localizedMessage ?: ""))
                }
            })
    }
)
