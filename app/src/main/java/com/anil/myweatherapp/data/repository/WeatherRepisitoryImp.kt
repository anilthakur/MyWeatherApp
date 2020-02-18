package com.android.artgallery.data.repository

import com.android.artgallery.data.source.remote.RetrofitService
import com.anil.myweatherapp.data.source.local.AppDataBase
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.usecase.currentweather.WeatherRepository
import io.reactivex.Single

class WeatherRepisitoryImp(
    private val database: AppDataBase,
    private val retrofitService: RetrofitService
) : WeatherRepository {
    override fun addWeatherDataToDataBase(weather: Weather) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeather(location: String, unit: String, appId: String): Single<Weather> {
        return retrofitService.getWeatherResult(location, unit, appId)
    }

    override fun loadDatafromDatabase(): Single<Weather> {
        return database.weatherDao.loadAll()
    }

    override fun storeToDB(obj: Weather) {
        database.weatherDao.insert(obj)
    }
}