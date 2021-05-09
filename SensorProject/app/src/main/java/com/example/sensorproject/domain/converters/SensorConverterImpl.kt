package com.example.sensorproject.domain.converters

import com.example.sensorproject.data.remote.models.AdvSensorApi
import com.example.sensorproject.data.remote.models.SensorApi
import com.example.sensorproject.domain.models.SensorItemList
import com.example.sensorproject.domain.models.SensorList

class SensorConverterImpl {

    fun fromApiToUISensor(model: SensorApi): SensorItemList {
        return SensorItemList(nameSensor = model.name, descSensor = model.desc, cordSensor = model.coordinates, statusSensor = model.status)
    }
}