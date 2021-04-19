package com.example.sensorproject.data.remote.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class SensorApi(
    val id: Int,
    val name: String,
    val coordinates: String,
    val time_zone: String,
    val status: String,
    val desc: String ) {

    companion object  {
        @UnstableDefault
        fun toObject(stringValue: String): SensorApi {
            return Json.nonstrict.parse(serializer(), stringValue)
        }
    }
}

// Extension for serialization
@UnstableDefault
fun SensorApi.toJson(): String {
    return Json.stringify(SensorApi.serializer(), this)
}
