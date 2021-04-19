package com.example.sensorproject.domain.converters

import com.example.sensorproject.data.remote.models.SensorApi
import com.example.sensorproject.domain.models.SensorItemList

class SensorConverterImpl {

    fun fromApiToUI(model: SensorApi): SensorItemList {
        return SensorItemList(nameSensor = model.name, descSensor = model.desc, cordSensor = model.coordinates, statusSensor = model.status)
    }
}