package com.anil.myweatherapp

import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Anil Kumar on 2020-02-16
 */
@RunWith(JUnit4::class)
class Weather_ForeCast_Test {
    @Test
    fun returnValue_GetName() {
        var value = WeatherForeCast()
        value.cod="123"
        MatcherAssert.assertThat(
            value.cod,
            CoreMatchers.`is`<String>(CoreMatchers.equalTo<String>("123"))
        )
    }
}