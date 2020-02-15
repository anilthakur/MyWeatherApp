package com.anil.myweatherapp.persentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import com.anil.myweatherapp.domain.usecase.currentweather.GetWeatherUseCaseImpl
import com.anil.myweatherapp.domain.usecase.forecastweatheer.GetWeatherForeCastImpl
import javax.inject.Inject

/**
 * Created by Anil Kumar on 2020-02-15
 */
class WeatherViewModel @Inject constructor(private val getWeatherUseCaseImpl: GetWeatherUseCaseImpl,private  val  getWeatherForeCastImpl: GetWeatherForeCastImpl) :
    ViewModel() {

    private val TAG = WeatherViewModel::class.java.simpleName
    val weatherLiveData = MutableLiveData<Weather>()
    val weatherForecastLiveData = MutableLiveData<WeatherForeCast>()
    val isLoad = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
        isError.value = false
    }


    fun loadCurrentWeather(location: String, unit: String, appId: String) {
        getWeatherUseCaseImpl.callmethod(location, unit, appId)
        getWeatherUseCaseImpl.execute(
            onSuccess = {
                isLoad.value = true
                weatherLiveData.value = it
            },
            onError = {
                it.printStackTrace()
                isError.value = true
            }
        )
    }
    fun loadForeCastWeather(location: String, unit: String, appId: String){
        getWeatherForeCastImpl.callmethod(location, unit, appId)
        getWeatherForeCastImpl.execute(
            onSuccess = {
                isLoad.value = true
                weatherForecastLiveData.value = it
            },
            onError = {
                it.printStackTrace()
                isError.value = true
            }
        )
    }
}