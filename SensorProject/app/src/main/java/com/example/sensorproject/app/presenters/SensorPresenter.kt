package com.example.sensorproject.app.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.sensorproject.app.models.SensorItemList
import com.example.sensorproject.app.views.SensorView
import java.util.ArrayList
import kotlin.concurrent.thread

@InjectViewState
class SensorPresenter : MvpPresenter<SensorView>() {
    fun PullSensor() {
        viewState.loadingSensor()

        val handler = Handler()
        thread {
            Thread.sleep(3000)
            val listItems = ArrayList<SensorItemList>()
            listItems.add(SensorItemList("Название", "Описание", "Кординаты", "Статус"))

            for (i in 0..9) {
                listItems.add(SensorItemList("Name $i", "CPRE$i", "432, 324", "active"))
            }

            handler.post {
                viewState.startSensor(data = listItems)
            }
        }
    }
}