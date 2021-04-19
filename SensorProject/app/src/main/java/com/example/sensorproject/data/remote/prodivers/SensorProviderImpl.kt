package com.example.sensorproject.data.remote.prodivers

import com.example.sensorproject.data.remote.helpers.RetrofitFactory
import com.example.sensorproject.data.remote.models.SensorApi
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault

class SensorProviderImpl {

    @UnstableDefault
    fun getSensorList(): Deferred<List<SensorApi>> {
        return RetrofitFactory.getSensorService().getSensor()
    }
}