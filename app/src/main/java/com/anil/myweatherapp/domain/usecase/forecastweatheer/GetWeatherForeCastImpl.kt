package com.anil.myweatherapp.domain.usecase.forecastweatheer

import com.android.artgallery.domain.usecase.base.SingleUseCase
import com.anil.myweatherapp.domain.model.forecastmodule.WeatherForeCast
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Anil Kumar on 2020-02-15
 */
class GetWeatherForeCastImpl @Inject constructor(private val repository: WeatherForeCastRepository) : SingleUseCase<WeatherForeCast>()  {

    private var location: String? = null
    private var unit: String? = null
    private var appId: String? = null

    fun callmethod(location: String,unit: String,appId: String) {
        this.location = location
        this.unit = unit
        this.appId = appId
    }

    override fun buildUseCaseSingle(): Single<WeatherForeCast> {
        return repository.getWeatherForeCast(location!!,unit!!,appId!!)
    }
}