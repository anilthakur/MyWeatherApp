package com.android.artgallery.data.source.remote

import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {



    @GET("data/2.5/weather")
     fun getWeatherResult(
        @Query("q") weather: String, @Query("units") unit: String, @Query(
            "appid"
        ) appID: String
    ): Single<Weather>


    @GET("data/2.5/forecast")
     fun getForeCastWeatherResult(
        @Query("q") weather: String, @Query("units") unit: String, @Query(
            "appid"
        ) appID: String
    ): Single<WeatherForeCast>
}