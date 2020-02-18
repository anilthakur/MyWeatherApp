package com.anil.myweatherapp.data.source.local.weatherDao

import androidx.room.TypeConverter
import com.anil.myweatherapp.domain.model.currentwethermodel.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

/**
 * Created by Anil Kumar on 2020-02-16
 */
class Converters {
    @TypeConverter
    fun fromStringToMain(value: String?): Main? {
        val type: Type = object : TypeToken<Main?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromStringToCache(value: Main?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromStringToClouds(value: String?): Clouds? {
        val type: Type = object : TypeToken<Clouds?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromStringToClouds(value: Clouds?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }


    @TypeConverter
    fun fromStringToSys(value: String?): Sys? {
        val type: Type = object : TypeToken<Sys?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromStringToSys(value: Sys?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }


    @TypeConverter
    fun fromStringToCoord(value: String?): Coord? {
        val type: Type = object : TypeToken<Coord?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromStringToCoord(value: Coord?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromStringToWind(value: String?): Wind? {
        val type: Type = object : TypeToken<Wind?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromStringToWind(value: Wind?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }


    @TypeConverter
    fun fromStringToWeatherItemList(value: String?): List<WeatherItem>? {
        val listType: Type = object : TypeToken<ArrayList<WeatherItem>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromWeatherItemListToString(list: List<WeatherItem?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}