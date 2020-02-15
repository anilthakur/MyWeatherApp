package com.anil.myweatherapp.domain.usecase.forecastweatheer

import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import io.reactivex.Single

/**
 * Created by Anil Kumar on 2020-02-15
 */
interface WeatherForeCastRepository{
    fun getWeatherForeCast(location:String,unit:String,appId:String): Single<WeatherForeCast>
}