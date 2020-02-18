package com.anil.myweatherapp.data.source.local.weatherDao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.artgallery.domain.usecase.base.SingleUseCase
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import io.reactivex.Single

/**
 * Created by Anil Kumar on 2020-02-16
 */
@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: Weather): Long
    @Query("SELECT * FROM Weather")
    fun loadAll(): Single<Weather>

}