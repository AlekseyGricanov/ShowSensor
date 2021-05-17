package com.example.sensorproject.data.remote.models

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class AdvSensorApi(
        val id: Int,
        val name: String,
        val status: Int,
        val channel_sensor: Int,
        val height_sensor: Int,
        val type_sensor: String,
        val recorder_sensor: String,
        val discrete_frequency_sensor: Int,
        val operator_sensor: String,
        val latitude_sensor: String,
        val longitude_sensor: String,
        val perc_memr_free_storage: Int,
        val perc_battery_storage: Int)
{

    companion object  {
        @UnstableDefault
        fun toObject(stringValue: String): AdvSensorApi {
            return Json.nonstrict.parse(serializer(), stringValue)
        }
    }
}

// Extension for serialization
@UnstableDefault
fun AdvSensorApi.toJson(): String {
    return Json.stringify(AdvSensorApi.serializer(), this)
}