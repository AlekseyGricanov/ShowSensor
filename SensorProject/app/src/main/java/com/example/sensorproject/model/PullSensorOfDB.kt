package com.arellomobile.mvp.sample.kotlin.model

import com.arellomobile.mvp.sample.kotlin.adapter.AdapterListSensor
import com.arellomobile.mvp.sample.kotlin.interfaces.SensorItemList
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