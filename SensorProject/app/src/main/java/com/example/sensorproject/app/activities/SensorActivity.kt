package com.example.sensorproject.app.activities

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.sensorproject.R
import com.example.sensorproject.androidx.MvpAppCompatActivity
import com.example.sensorproject.app.presenters.AdvSensorPresenter
import com.example.sensorproject.app.views.AdvSensorView
import com.example.sensorproject.data.remote.models.AdvSensorApi
import kotlinx.android.synthetic.main.activity_sensor.*
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

        sensorPresenter.pullAdvSensor(idSensor)
    }

    override fun startSensor(data: AdvSensorApi) {
        desc_sensor_list_layout.visibility = VISIBLE
        name_stat_for_detail.visibility = VISIBLE
        textLoading.visibility = GONE

        //Название и статус датчика
        name_sensor.text = data.name
        when (data.status) {
            1 -> stat_sensor.setImageResource(R.drawable.green_circle_100)
            0 -> stat_sensor.setImageResource(R.drawable.red_circle_100)
            else -> stat_sensor.setImageResource(R.drawable.yellow_circle_100)
        }

        //Батарея и память
        bat_sensor.text = data.perc_battery_storage.toString() + "%"
        stor_sensor.text = data.perc_memr_free_storage.toString() + "%"

        when (data.perc_battery_storage) {
            in 80..100 -> bat_sensor_img.setImageResource(R.drawable.full_battery_green)
            in 40..80 -> bat_sensor_img.setImageResource(R.drawable.half_battery_yellow)
            else -> bat_sensor_img.setImageResource(R.drawable.low_battery_red)
        }

        when (data.perc_memr_free_storage) {
            in 80..100 -> stor_sensor_img.setImageResource(R.drawable.storage_full_red)
            in 40..80 -> stor_sensor_img.setImageResource(R.drawable.storage_half_yellow)
            else -> stor_sensor_img.setImageResource(R.drawable.storage_low_green)
        }

        //Детали
        channel_sensor.text = data.channel_sensor.toString()
        height_sensor.text = data.height_sensor.toString()
        type_sensor.text = data.type_sensor
        recorder_sensor.text = data.recorder_sensor
        discrete_frequency_sensor.text = data.discrete_frequency_sensor.toString()
        operator_sensor.text = data.operator_sensor
    }

    override fun loadingSensor() {
        desc_sensor_list_layout.visibility = GONE
        name_stat_for_detail.visibility = GONE
        textLoading.visibility = VISIBLE
    }
}