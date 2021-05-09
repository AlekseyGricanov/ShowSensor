package com.example.sensorproject.domain.converters;

import com.example.sensorproject.data.remote.models.AdvSensorApi
import com.example.sensorproject.domain.models.SensorList

class AdvSensorConverterImpl {

    fun fromApiToUIAdvSensor(model: AdvSensorApi): SensorList {
        return SensorList(id = model.id, timeLastUpdate = model.time_last_update, perStorage = model.per_storage, timeService = model.time_service, idSensor = model.id_sensor)
    }
}