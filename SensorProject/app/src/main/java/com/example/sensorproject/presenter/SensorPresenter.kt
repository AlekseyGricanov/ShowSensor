package com.arellomobile.mvp.sample.kotlin.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.sample.kotlin.interfaces.SensorItemList
import com.arellomobile.mvp.sample.kotlin.model.PullSensorOfDB
import com.arellomobile.mvp.sample.kotlin.view.SensorView
import java.util.ArrayList

@InjectViewState
class SensorPresenter : MvpPresenter<SensorView>() {
    fun PullSensor() {
        var listItems: MutableList<SensorItemList> = ArrayList()
        val PullSensorOfDB = PullSensorOfDB(listItems)


        listItems = PullSensorOfDB.pullSensorList()

        viewState.startSensor(listItems)
        viewState.shortMessage("Датчики обновлены")
    }
}