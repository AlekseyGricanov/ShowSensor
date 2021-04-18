package com.example.sensorproject.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.sensorproject.models.SensorItemList
import com.example.sensorproject.api.PullSensorOfDB
import com.example.sensorproject.views.SensorView
import java.util.ArrayList

@InjectViewState
class SensorPresenter : MvpPresenter<SensorView>() {
    fun PullSensor() {
        var listItems: MutableList<SensorItemList> = ArrayList()
        val PullSensorOfDB = PullSensorOfDB(listItems)

        Thread {
            listItems = PullSensorOfDB.pullSensorList()

            viewState.startSensor(listItems)
        }
    }
}