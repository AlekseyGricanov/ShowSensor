package com.example.sensorproject.domain.converters

import com.example.sensorproject.data.remote.models.SensorApi
import com.example.sensorproject.domain.models.SensorItemList

class SensorConverterImpl {

    fun fromApiToUISensor(model: SensorApi): SensorItemList {
        return SensorItemList(idSensor = model.id ,nameSensor = model.name, descSensor = model.desc, cordSensor = model.coordinates, statusSensor = model.status)
    }
}