//package com.android.artgallery.data.source.local.dao
//
//
//import androidx.room.*
//import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
//
///**
// * it provides access to [Photo] underlying database
// * */
//@Dao
//interface WeatheerDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(photo: Weather): Long
//
//    @Query("SELECT * FROM Weather")
//    fun loadAll(): MutableList<Weather>
//
//
//}