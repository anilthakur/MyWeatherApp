package com.android.artgallery.data.repository

import com.android.artgallery.data.source.remote.RetrofitService
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.usecase.currentweather.WeatherRepository
import io.reactivex.Single

class WeatherRepisitoryImp(

    private val retrofitService: RetrofitService
) : WeatherRepository {
    override fun getWeather(location: String, unit: String, appId: String): Single<Weather> {
        return retrofitService.getWeatherResult(location, unit, appId)
    }


}