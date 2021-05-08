package com.example.sensorproject.domain.repositories.implementations

import com.example.sensorproject.data.remote.prodivers.SensorProviderImpl
import com.example.sensorproject.domain.converters.SensorConverterImpl
import com.example.sensorproject.domain.models.SensorItemList
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.serialization.UnstableDefault

class SensorRepositoryImpl(private val sensorConverter: SensorConverterImpl) {
    private val sensorProvider: SensorProviderImpl = SensorProviderImpl()

    @UnstableDefault
    suspend fun PullSensor(): Deferred<List<SensorItemList>> {
        return try {
            val sensor = sensorProvider.getSensorListAsync().await()
            GlobalScope.async {
                sensor.map { sensor -> sensorConverter.fromApiToUISensor(model = sensor)  }
            }
        } catch (e: Exception)  {
            GlobalScope.async { error(e) }
        }
    }
}