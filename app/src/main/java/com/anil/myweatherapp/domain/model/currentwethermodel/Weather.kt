package com.anil.myweatherapp.domain.model.currentwethermodel

import com.google.gson.annotations.SerializedName
data class Weather(

    @field:SerializedName("visibility")
	val visibility: Int? = null,

    @field:SerializedName("timezone")
	val timezone: Int? = null,

    @field:SerializedName("main")
	val main: Main? = null,

    @field:SerializedName("clouds")
	val clouds: Clouds? = null,

    @field:SerializedName("sys")
	val sys: Sys? = null,

    @field:SerializedName("dt")
	val dt: Int? = null,

    @field:SerializedName("coord")
	val coord: Coord? = null,

    @field:SerializedName("weather")
    var weather: List<WeatherItem?>? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("cod")
	val cod: Int? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("base")
	val base: String? = null,

    @field:SerializedName("wind")
	val wind: Wind? = null
)