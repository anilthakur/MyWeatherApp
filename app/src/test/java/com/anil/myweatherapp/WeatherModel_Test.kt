package com.anil.myweatherapp

import com.android.artgallery.util.Constants
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.currentwethermodel.WeatherItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Anil Kumar on 2020-02-16
 */
@RunWith(JUnit4::class)
class WeatherModel_Test{
    @Test
    fun returnValue_GetName() {
        var value = Weather()
        value.name="Bangalore"
        assertThat(value.name, `is`<String>(equalTo<String>("Bangalore")))
    }

    @Test
    fun getWeatherItem() {
        var value = Weather()
        var weatherItem=WeatherItem()
        weatherItem.description = "description"
        weatherItem.icon="icon"
        weatherItem.id=1
        weatherItem.main="main"
        var arrayListWeatherItem= listOf<WeatherItem>()
        arrayListWeatherItem = listOf(weatherItem)
        value.weather = arrayListWeatherItem

        assertThat((value.weather as List<WeatherItem>).size, `is`<Int>(equalTo<Int>(1)))
    }

}