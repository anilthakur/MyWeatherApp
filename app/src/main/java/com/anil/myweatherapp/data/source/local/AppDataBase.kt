package com.anil.myweatherapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anil.myweatherapp.data.source.local.weatherDao.Converters
import com.anil.myweatherapp.data.source.local.weatherDao.WeatherDao
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather

/**
 * Created by Anil Kumar on 2020-02-16
 */
@Database(entities = [Weather::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract val weatherDao: WeatherDao

    companion object {
        const val DB_NAME = "WeatherDatabase.db"
    }
}