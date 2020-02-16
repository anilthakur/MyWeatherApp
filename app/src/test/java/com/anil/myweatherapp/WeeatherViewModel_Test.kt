package com.anil.myweatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import com.anil.myweatherapp.domain.usecase.currentweather.GetWeatherUseCaseImpl
import com.anil.myweatherapp.domain.usecase.forecastweatheer.GetWeatherForeCastImpl
import com.anil.myweatherapp.persentation.viewmodel.WeatherViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Anil Kumar on 2020-02-16
 */
@RunWith(MockitoJUnitRunner::class)
class WeeatherViewModel_Test {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var weatherUseCaseImpl: GetWeatherUseCaseImpl

    @Mock
    private lateinit var weatherForeCastImpl: GetWeatherForeCastImpl

    private lateinit var subject: WeatherViewModel

    val weatherLiveData = MutableLiveData<Weather>()
    val weatherForecastLiveData = MutableLiveData<WeatherForeCast>()
    val isLoad = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        subject = WeatherViewModel(weatherUseCaseImpl, weatherForeCastImpl)

    }

    @Test
    fun testUseCases_getWeather_Completed() {
        subject.loadCurrentWeather(
            "Bangalore,karnataka",
            "metric",
            "8887e1c31f3251430bf8523f2647c959"
        )
        then(weatherLiveData.postValue(Weather()))
    }

    @Test
    fun testUseCases_getForeCastWeather_Completed() {
        subject.loadForeCastWeather(
            "Bangalore,karnataka",
            "metric",
            "8887e1c31f3251430bf8523f2647c959"
        )
        then(weatherForecastLiveData.postValue(WeatherForeCast()))

    }

    @Test
    fun testWeather_API_Fail(){
        subject.loadForeCastWeather(
            "Bangalore,karnataka",
            "metric",
            "8887e1c31f3251430bf8523f2647c959"
        )
        then(isLoad.postValue(true))
    }

    @Test
    fun testError_API_Fail(){
        subject.loadForeCastWeather(
            "Bangalore,karnataka",
            "metric",
            ""
        )
        then(isError.value)
    }

}