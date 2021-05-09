package com.example.sensorproject.domain.repositories.implementations

import com.example.sensorproject.data.remote.prodivers.SensorProviderImpl
import com.example.sensorproject.domain.converters.AdvSensorConverterImpl
import com.example.sensorproject.domain.models.SensorList
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.serialization.UnstableDefault

class AdvSensorRepositoryImpl(private val sensorConverter: AdvSensorConverterImpl) {
    private val sensorProvider: SensorProviderImpl = SensorProviderImpl()

    @UnstableDefault
    suspend fun PullAdvSensor(): Deferred<List<SensorList>> {
        return try {
            val advSensor = sensorProvider.getAdvSensorListAsync().await()
            GlobalScope.async {
                advSensor.map { advSensor -> sensorConverter.fromApiToUIAdvSensor(model = advSensor)  }
            }
        } catch (e: Exception)  {
            GlobalScope.async { error(e) }
        }
    }
}