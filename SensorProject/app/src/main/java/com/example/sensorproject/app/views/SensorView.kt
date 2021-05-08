package com.example.sensorproject.app.views

import com.arellomobile.mvp.MvpView
import com.example.sensorproject.domain.models.SensorItemList

interface SensorView: MvpView {
    fun startSensor(data: List<SensorItemList>)
    fun loadingSensor()
}