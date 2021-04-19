package com.example.sensorproject.app.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.sensorproject.domain.models.SensorItemList
import com.example.sensorproject.app.views.SensorView
import com.example.sensorproject.data.remote.prodivers.SensorProviderImpl
import com.example.sensorproject.domain.converters.SensorConverterImpl
import com.example.sensorproject.domain.repositories.implementations.SensorRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.UnstableDefault
import java.util.ArrayList
import kotlin.concurrent.thread

@InjectViewState
class SensorPresenter : MvpPresenter<SensorView>() {
    private val sensorRepositoryImpl = SensorRepositoryImpl(sensorConverter = SensorConverterImpl())

    @UnstableDefault
    fun PullSensor() {
        viewState.loadingSensor()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val sensors = sensorRepositoryImpl.PullSensor().await()
                withContext(Dispatchers.Main) {
                    viewState.startSensor(data = sensors)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }
}