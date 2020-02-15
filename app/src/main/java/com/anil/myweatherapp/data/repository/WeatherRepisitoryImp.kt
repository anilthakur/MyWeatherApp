package com.android.artgallery.data.repository

//import com.android.artgallery.data.source.local.AppDatabase
import com.android.artgallery.data.source.remote.RetrofitService
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.usecase.currentweather.WeatherRepository
import io.reactivex.Single

/**
 * This repository is responsible for
 * fetching data [photo] from server or db
 * */
class WeatherRepisitoryImp(
//    private val database: AppDatabase,

    private val retrofitService: RetrofitService
) : WeatherRepository {
    override fun getWeather(location: String, unit: String, appId: String): Single<Weather> {
        return retrofitService.getWeatherResult(location, unit, appId)
    }


}