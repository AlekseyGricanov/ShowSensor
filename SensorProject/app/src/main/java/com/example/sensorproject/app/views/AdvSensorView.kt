package com.example.sensorproject.app.views

import com.arellomobile.mvp.MvpView
import com.example.sensorproject.domain.models.SensorList

interface AdvSensorView: MvpView {
    fun startSensor(data: List<SensorList>)
    fun loadingSensor()
}