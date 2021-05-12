package com.example.sensorproject.data.remote.sevices

import com.example.sensorproject.data.remote.models.AdvSensorApi
import com.example.sensorproject.data.remote.models.SensorApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface SensorService {

    @GET("./")
    fun getSensorAsync(): Deferred<List<SensorApi>>

    @GET("sensor/{id}")
    fun getAdvSensorAsync(@Path("id") id: Int): Deferred<List<AdvSensorApi>>
}