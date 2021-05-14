package com.example.sensorproject.data.remote.prodivers

import android.content.ContentValues
import android.util.Log
import com.example.sensorproject.data.remote.helpers.RetrofitFactory
import com.example.sensorproject.data.remote.models.AdvSensorApi
import com.example.sensorproject.data.remote.models.SensorApi
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault

class SensorProviderImpl {

    @UnstableDefault
    fun getSensorListAsync(): Deferred<List<SensorApi>> {
        return RetrofitFactory.getSensorService().getSensorAsync()
    }

    @UnstableDefault
    fun getAdvSensorListAsync(idSensor: Int): Deferred<AdvSensorApi> {
        return RetrofitFactory.getSensorService().getAdvSensorAsync(idSensor)
    }
}