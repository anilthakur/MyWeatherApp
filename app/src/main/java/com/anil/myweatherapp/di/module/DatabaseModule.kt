package com.anil.myweatherapp.di.module

import android.app.Application
import androidx.room.Room
import com.anil.myweatherapp.data.source.local.AppDataBase
import com.anil.myweatherapp.data.source.local.weatherDao.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDataBase {
        return Room.databaseBuilder(
            application,
            AppDataBase::class.java,
            AppDataBase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun providePhotoDao(appDatabase: AppDataBase): WeatherDao {
        return appDatabase.weatherDao
    }
}