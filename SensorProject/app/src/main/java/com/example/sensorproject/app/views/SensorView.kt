package com.example.sensorproject.app.views

import com.arellomobile.mvp.MvpView
import com.example.sensorproject.app.models.SensorItemList

interface SensorView: MvpView {
    fun startSensor(listItems: MutableList<SensorItemList>)
    //fun shortMessage(text: String)
    //fun loadingSensor(text: String)
    //fun endSensor()
}