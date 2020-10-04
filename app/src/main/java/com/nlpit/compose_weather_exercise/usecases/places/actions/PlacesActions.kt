package com.nlpit.compose_weather_exercise.usecases.places.actions

import com.nlpit.compose_weather_exercise.framework.redux.Action
import com.nlpit.compose_weather_exercise.framework.redux.middlewares.async.AsyncAction
import com.nlpit.compose_weather_exercise.usecases.DI
import com.nlpit.compose_weather_exercise.usecases.error_handling.actions.ErrorActions
import com.nlpit.compose_weather_exercise.usecases.places.entities.Place
import com.nlpit.compose_weather_exercise.usecases.places.entities.asPlaces
import com.nlpit.networking.api.mapping.places.SimplePlaceGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchLocationsUnsuccessful(errorMessage: String) : ErrorActions(errorMessage)
class FetchLocationsSuccessful(val places: List<Place>) : Action(places)

class FetchLocationsAction : AsyncAction(
    asyncFun = suspend {
        val ids = DI.woeIds.joinToString(separator = ",")
        DI.weatherAPI.placesQuery(ids = ids)
            .enqueue(object : Callback<SimplePlaceGroup> {
                override fun onResponse(
                    call: Call<SimplePlaceGroup>,
                    response: Response<SimplePlaceGroup>
                ) {
                    if (!response.isSuccessful) {
                        DI.dispatch(FetchLocationsUnsuccessful(errorMessage = response.message()))
                    }

                    val result = response.body()
                    if (result == null) {
                        DI.dispatch(FetchLocationsUnsuccessful(errorMessage = "Response has no body"))
                    }

                    result?.let { placeGroup ->
                        DI.dispatch(FetchLocationsSuccessful(placeGroup.asPlaces()))
                    }
                }

                override fun onFailure(call: Call<SimplePlaceGroup>, t: Throwable) {
                    DI.dispatch(FetchLocationsUnsuccessful(errorMessage = t.localizedMessage ?: ""))
                }
            })
    }
)
