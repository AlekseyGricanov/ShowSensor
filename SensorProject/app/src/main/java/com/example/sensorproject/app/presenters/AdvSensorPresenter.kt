package com.example.sensorproject.app.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.sensorproject.app.views.AdvSensorView
import com.example.sensorproject.domain.converters.AdvSensorConverterImpl
import com.example.sensorproject.domain.repositories.implementations.AdvSensorRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.UnstableDefault

@InjectViewState
class AdvSensorPresenter : MvpPresenter<AdvSensorView>() {
    private val advSensorRepositoryImpl = AdvSensorRepositoryImpl(sensorConverter = AdvSensorConverterImpl())

    @UnstableDefault
    fun PullAdvSensor(idSensor: Int) {
        viewState.loadingSensor()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val advSensors = advSensorRepositoryImpl.pullAdvSensorAsync(idSensor).await()
                withContext(Dispatchers.Main) {
                    viewState.startSensor(data = advSensors)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}