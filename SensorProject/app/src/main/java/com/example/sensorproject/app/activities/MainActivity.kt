package com.example.sensorproject.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sensorproject.androidx.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.sensorproject.R
import com.example.sensorproject.app.adapter.AdapterListSensor
import com.example.sensorproject.app.adapter.AdapterListSensor.OnClickListener
import com.example.sensorproject.app.presenters.SensorPresenter
import com.example.sensorproject.app.views.SensorView
import com.example.sensorproject.domain.models.SensorItemList
import kotlinx.android.synthetic.main.main_sensor_list.*
import kotlinx.serialization.UnstableDefault


class MainActivity : MvpAppCompatActivity(), SensorView, OnClickListener{

    private val listAdapter = AdapterListSensor(this)

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var sensorPresenter: SensorPresenter

    @UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sensor_list)
        setupAdapter()

        sensorPresenter.pullSensor()
    }

    private fun setupAdapter() {
        val linearLayoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        listSensor.layoutManager = linearLayoutManager
        listSensor.adapter = listAdapter
    }

    override fun startSensor(data: List<SensorItemList>) {
        listSensor.visibility = View.VISIBLE
        textListLoading.visibility = View.GONE

        listAdapter.setDate(newItemView = data)
    }

    override fun loadingSensor() {
        listSensor.visibility = View.GONE
        textListLoading.visibility = View.VISIBLE
    }

    override fun onClickListener(idSensor: Int) {
        val randomIntent = Intent(this, SensorActivity::class.java)
        randomIntent.putExtra("idSensor", idSensor);
        startActivity(randomIntent)
    }
}