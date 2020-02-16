package com.anil.myweatherapp.data.repository

import com.android.artgallery.data.source.remote.RetrofitService
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import com.anil.myweatherapp.domain.usecase.forecastweatheer.WeatherForeCastRepository
import io.reactivex.Single

/**
 * Created by Anil Kumar on 2020-02-15
 */
class ForeCastWeatherRepsitryImpl(
    private val retrofitService: RetrofitService
) : WeatherForeCastRepository {
    override fun getWeatherForeCast(
        location: String,
        unit: String,
        appId: String
    ): Single<WeatherForeCast> {
        return retrofitService.getForeCastWeatherResult(location, unit, appId)
    }


}