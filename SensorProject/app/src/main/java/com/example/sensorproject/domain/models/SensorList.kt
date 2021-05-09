package com.example.sensorproject.domain.models

data class SensorList (
    var id: Int,
    var timeLastUpdate: String,
    var perStorage: Int,
    var timeService: String,
    var idSensor: Int
)