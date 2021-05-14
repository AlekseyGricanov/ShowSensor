package com.example.sensorproject.domain.repositories.implementations

import com.example.sensorproject.data.remote.models.AdvSensorApi
import com.example.sensorproject.data.remote.prodivers.SensorProviderImpl
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.serialization.UnstableDefault

class AdvSensorRepositoryImpl() {
    private val sensorProvider: SensorProviderImpl = SensorProviderImpl()

    @UnstableDefault
    suspend fun pullAdvSensorAsync(idSensor: Int): Deferred<AdvSensorApi> {
        return try {
            val advSensor = sensorProvider.getAdvSensorListAsync(idSensor = idSensor).await()
            GlobalScope.async {
                advSensor
            }
        } catch (e: Exception)  {
            GlobalScope.async { error(e) }
        }
    }
}