//package com.android.artgallery.data.source.local
//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.android.artgallery.data.source.local.dao.WeatheerDao
//import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
//import com.anil.myweatherapp.persentation.viewmodel.WeatherTypeConverte
//
///**
// * To manage data items that can be accessed, updated
// * & maintain relationships between them
// *
// * @Created by ZARA
// */
//@Database(entities = [Weather::class], version = 1, exportSchema = false)
//@TypeConverters(WeatherTypeConverte::class)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract val weatheerDao: WeatheerDao
//
//    companion object {
//        const val DB_NAME = "WeatherDatabase.db"
//    }
//}
