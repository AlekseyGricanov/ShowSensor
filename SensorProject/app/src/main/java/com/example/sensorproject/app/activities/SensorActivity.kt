package com.example.sensorproject.app.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.sensorproject.R
import com.example.sensorproject.app.adapter.AdapterSensor
import com.example.sensorproject.app.presenters.AdvSensorPresenter
import com.example.sensorproject.app.views.AdvSensorView
import com.example.sensorproject.domain.models.SensorList
import kotlinx.serialization.UnstableDefault
import kotlinx.android.synthetic.main.activity_sensor.*


class SensorActivity : MvpAppCompatActivity(), AdvSensorView {

    private val listAdapter = AdapterSensor()


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var sensorPresenter: AdvSensorPresenter

    @UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)
        setupAdapter()

        sensorPresenter.PullAdvSensor()
    }

    private fun setupAdapter() {
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        sensors.layoutManager = linearLayoutManager
        sensors.adapter = listAdapter
    }

    override fun startSensor(data: List<SensorList>) {
        sensors.visibility = View.VISIBLE
        textLoading.visibility = View.GONE

        listAdapter.setDate(newItemView = data)
    }

    override fun loadingSensor() {
        sensors.visibility = View.GONE
        textLoading.visibility = View.VISIBLE
    }
}