package com.arellomobile.mvp.sample.kotlin.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.sample.kotlin.interfaces.SensorItemList

interface SensorView: MvpView {
    fun startSensor(listItems: MutableList<SensorItemList>)
    fun shortMessage(text: String)
    fun endSensor()
}