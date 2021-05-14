package com.example.sensorproject.data.remote.models

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class AdvSensorApi(
        val id: Int,
        val time_last_update: String,
        val per_storage: Int,
        val time_service: String,
        val id_sensor: Int)
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