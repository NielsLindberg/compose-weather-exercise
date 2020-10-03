package com.nlpit.networking.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nlpit.networking.api.mapping.forecast.SimpleForecastGroup
import com.nlpit.networking.api.mapping.places.SimplePlaceGroup
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val baseUrl = "https://api.openweathermap.org/data/2.5/"

interface WeatherAPI {
    @GET("group")
    fun placesQuery(
        @Query("id") ids: String,
        @Query("units") units: String = "metric"
    ): Call<SimplePlaceGroup>

    /**
     * Added query for forecast.
     */
    @GET("forecast")
    fun forecastQuery(
        @Query("id") id: String,
        @Query("units") units: String = "metric"
    ): Call<SimpleForecastGroup>
}

fun initHttpClient(apiKey: String): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().addQueryParameter("appid", apiKey).build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }.build()
}

fun initWeatherAPI(httpClient: OkHttpClient): WeatherAPI {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(
            Json {
                this.ignoreUnknownKeys = true
                this.isLenient = true
            }.asConverterFactory(MediaType.get("application/json"))
        )
        .build()

    return retrofit.create(WeatherAPI::class.java)
}