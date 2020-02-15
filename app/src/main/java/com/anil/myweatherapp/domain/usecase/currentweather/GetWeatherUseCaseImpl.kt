package com.anil.myweatherapp.domain.usecase.currentweather

import com.android.artgallery.domain.usecase.base.SingleUseCase
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Anil Kumar on 2020-02-15
 */
class GetWeatherUseCaseImpl @Inject constructor(private val repository: WeatherRepository) : SingleUseCase<Weather>()  {

    private var location: String? = null
    private var unit: String? = null
    private var appId: String? = null

    fun callmethod(location: String,unit: String,appId: String) {
        this.location = location
        this.unit = unit
        this.appId = appId
    }

    override fun buildUseCaseSingle(): Single<Weather> {
        return repository.getWeather(location!!,unit!!,appId!!)
    }
}