package com.example.week1.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.AndroidViewModel
import com.example.week1.BuildConfig
import com.example.week1.data.model.WeatherEntity
import com.example.week1.data.local.AppDatabase
import com.example.week1.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import android.app.Application

class WeatherViewModel (application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).weatherDao()
    private val repository = WeatherRepository(dao, BuildConfig.OPENWEATHER_API_KEY)
    private val _currentWeather = MutableStateFlow<WeatherEntity?>(null)
    val currentWeather: StateFlow<WeatherEntity?> = _currentWeather
    val history = repository.getAllHistory()

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            val result = repository.getWeather(city)
            _currentWeather.value = result
        }
    }
}