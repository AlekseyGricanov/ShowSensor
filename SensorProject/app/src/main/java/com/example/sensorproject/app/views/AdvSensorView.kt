package com.example.sensorproject.app.views

import com.arellomobile.mvp.MvpView
import com.example.sensorproject.data.remote.models.AdvSensorApi

interface AdvSensorView: MvpView {
    fun startSensor(data: AdvSensorApi)
    fun loadingSensor()
}