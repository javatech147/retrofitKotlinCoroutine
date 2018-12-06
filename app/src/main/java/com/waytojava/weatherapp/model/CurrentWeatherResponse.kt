package com.waytojava.weatherapp.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val current: Current,
    val location: Location
)