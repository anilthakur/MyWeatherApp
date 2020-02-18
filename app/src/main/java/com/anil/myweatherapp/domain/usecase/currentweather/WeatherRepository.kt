package com.anil.myweatherapp.domain.usecase.currentweather

import androidx.lifecycle.MutableLiveData
import com.android.artgallery.domain.usecase.base.SingleUseCase
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import com.anil.myweatherapp.domain.usecase.base.Repository
import io.reactivex.Single

/**
 * Created by Anil Kumar on 2020-02-15
 */
interface WeatherRepository : Repository<Weather> {
    fun getWeather(location:String,unit:String,appId:String): Single<Weather>
    fun addWeatherDataToDataBase(weather: Weather)
    fun loadDatafromDatabase():Single<Weather>
}