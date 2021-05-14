package com.example.sensorproject.app.activities

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.sensorproject.R
import com.example.sensorproject.androidx.MvpAppCompatActivity
import com.example.sensorproject.app.presenters.AdvSensorPresenter
import com.example.sensorproject.app.views.AdvSensorView
import com.example.sensorproject.data.remote.models.AdvSensorApi
import kotlinx.android.synthetic.main.activity_sensor.*
//import kotlinx.android.synthetic.main.item_activity_sensor.*
import kotlinx.serialization.UnstableDefault


class SensorActivity : MvpAppCompatActivity(), AdvSensorView {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var sensorPresenter: AdvSensorPresenter

    @UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        val intent = intent
        val idSensor = intent.getIntExtra("idSensor", -1)

        Toast.makeText(this, "message: $idSensor", Toast.LENGTH_SHORT).show()

//        setupAdapter()

        sensorPresenter.PullAdvSensor(idSensor)
    }

//    private fun setupAdapter() {
//        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        sensors.layoutManager = linearLayoutManager
//        sensors.adapter = listAdapter
//    }

    override fun startSensor(data: AdvSensorApi) {
//        sensors.visibility = View.VISIBLE
//        textLoading.visibility = View.GONE

        l_u_date_sensor_main.text = data.time_last_update
        stor_sensor_main.text = data.per_storage.toString()
//        listAdapter.setDate(newItemView = data)
    }

    override fun loadingSensor() {
//        sensors.visibility = View.GONE
//        textLoading.visibility = View.VISIBLE
    }
}