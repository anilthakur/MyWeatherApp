package com.anil.myweatherapp.domain.usecase.currentweather

import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import io.reactivex.Single

/**
 * Created by Anil Kumar on 2020-02-15
 */
interface WeatherRepository {
    fun getWeather(location:String,unit:String,appId:String): Single<Weather>

}