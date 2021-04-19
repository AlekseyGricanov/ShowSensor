package com.example.sensorproject.data.remote.sevices

import com.example.sensorproject.data.remote.models.SensorApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface SensorService {

    @GET("./")
    fun getSensor(): Deferred<List<SensorApi>>
}