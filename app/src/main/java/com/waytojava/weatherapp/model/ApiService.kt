package com.waytojava.weatherapp.model

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Manish Kumar on 12/6/2018
 */

const val API_KEY = "e1decbf01ac04441bf364745180612"
// http://api.apixu.com/v1/current.json?key= e1decbf01ac04441bf364745180612&q=New Delhi&lang=en

interface ApiService {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>
}