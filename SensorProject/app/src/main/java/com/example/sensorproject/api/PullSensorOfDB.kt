package com.example.sensorproject.api

import com.example.sensorproject.adapter.AdapterListSensor
import com.example.sensorproject.models.SensorItemList
import java.util.ArrayList

class PullSensorOfDB(listItems: List<SensorItemList>) : AdapterListSensor(listItems) {
    fun pullSensorList(): MutableList<SensorItemList> {
        val listItems: MutableList<SensorItemList> = ArrayList()

        listItems.add(SensorItemList("Название", "Описание", "Кординаты", "Статус"))

        for (i in 0..9) {
            listItems.add(SensorItemList("Name $i", "CPRE$i", "432, 324", "active"))
        }

        return listItems
    }
}