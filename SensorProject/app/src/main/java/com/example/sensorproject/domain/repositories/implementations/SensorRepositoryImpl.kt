package com.example.sensorproject.domain.repositories.implementations

import com.example.sensorproject.data.remote.prodivers.SensorProviderImpl
import com.example.sensorproject.domain.converters.SensorConverterImpl
import com.example.sensorproject.domain.models.SensorItemList
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.serialization.UnstableDefault
import java.util.ArrayList

class SensorRepositoryImpl(private val sensorConverter: SensorConverterImpl) {
    private val sensorProvider: SensorProviderImpl = SensorProviderImpl()

    @UnstableDefault
    suspend fun PullSensor(): Deferred<List<SensorItemList>> {
        return try {
            val sensor = sensorProvider.getSensorList().await()
            GlobalScope.async {
                sensor.map { sensor -> sensorConverter.fromApiToUI(model = sensor)  }
            }
        } catch (e: Exception)  {
            GlobalScope.async { error(e) }
        }

    //        Thread.sleep(3000)
//
//        val listItems = ArrayList<SensorItemList>()
//        listItems.add(SensorItemList("Название", "Описание", "Кординаты", "Статус"))
//
//        for (i in 0..9) {
//            listItems.add(SensorItemList("Name $i", "CPRE$i", "432, 324", "active"))
//        }
//
//        return GlobalScope.async { listItems }
    }
}