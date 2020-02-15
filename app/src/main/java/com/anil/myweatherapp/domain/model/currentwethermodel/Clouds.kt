package com.anil.myweatherapp.domain.model.currentwethermodel

import com.google.gson.annotations.SerializedName

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)