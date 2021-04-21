package com.example.sensorproject.app.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.sensorproject.R
import com.example.sensorproject.app.adapter.AdapterListSensor
import com.example.sensorproject.app.presenters.SensorPresenter
import com.example.sensorproject.app.views.SensorView
import com.example.sensorproject.domain.models.SensorItemList
import kotlinx.android.synthetic.main.main_sensor_list.*
import kotlinx.serialization.UnstableDefault


class MainActivity : MvpAppCompatActivity(), SensorView {

    private val listAdapter = AdapterListSensor()


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var sensorPresenter: SensorPresenter

//    @ProvidePresenterTag(presenterClass = SensorPresenter::class, type = PresenterType.GLOBAL)
//    fun provideDialogPresenterTag(): String = "Hello"
//
//    @ProvidePresenter(type = PresenterType.GLOBAL)
//    fun provideDialogPresenter() = SensorPresenter()

    @UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sensor_list)
        setupAdapter()

        sensorPresenter.PullSensor()
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


}