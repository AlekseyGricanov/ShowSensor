package com.example.sensorproject.app.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.sensorproject.domain.models.SensorItemList

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SensorView: MvpView {
    fun startSensor(data: List<SensorItemList>)
    fun loadingSensor()
    //fun shortMessage(text: String)
    //fun endSensor()
}