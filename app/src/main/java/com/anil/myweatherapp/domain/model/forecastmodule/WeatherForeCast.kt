package com.anil.myweatherapp.domain.model.forecastmodule

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class WeatherForeCast(

	@field:SerializedName("city")
	var city: City? = null,

	@field:SerializedName("cnt")
	val cnt: Int? = null,

	@field:SerializedName("cod")
	var cod: String? = null,

	@field:SerializedName("message")
	val message: Int? = null,

	@field:SerializedName("list")
	val list: List<ListItem?>? = null
)