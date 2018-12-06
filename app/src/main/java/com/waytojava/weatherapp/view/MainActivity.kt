package com.waytojava.weatherapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.waytojava.weatherapp.R
import com.waytojava.weatherapp.model.ApiClient
import com.waytojava.weatherapp.model.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const val API_KEY = "e1decbf01ac04441bf364745180612"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = "New Delhi"
        val languageCode = "en"

        val apiService: ApiService = ApiClient.invoke()
        btnGetCurrentWeather.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val response = apiService.getCurrentWeather(API_KEY, city, languageCode).await()
                responseJson.text = response.toString()
            }
        }
    }
}
