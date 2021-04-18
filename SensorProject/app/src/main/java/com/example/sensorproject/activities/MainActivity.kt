package com.example.sensorproject.activities

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.sample.kotlin.R
import com.example.sensorproject.adapter.AdapterListSensor
import com.arellomobile.mvp.sample.kotlin.presenter.SensorPresenter
import com.arellomobile.mvp.sample.kotlin.view.SensorView
import com.example.sensorproject.models.SensorItemList
import kotlinx.android.synthetic.main.main_sensor_list.*


class MainActivity : MvpAppCompatActivity(), SensorView {

    private val adapter = AdapterListSensor()


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var sensorPresenter: SensorPresenter

//    @ProvidePresenterTag(presenterClass = SensorPresenter::class, type = PresenterType.GLOBAL)
//    fun provideDialogPresenterTag(): String = "Hello"

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideDialogPresenter() = SensorPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sensor_list)
        sensorPresenter.PullSensor()
        //setupAdapter()
        //rootView.setOnClickListener { dialogPresenter.onShowDialogClick() }
    }

    override fun startSensor(date: List<SensorItemList>) {

        //adapter.setDate(newItemView = date)
    }

    private fun setupAdapter() {
        val recyclerView: RecyclerView = findViewById(R.id.list)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val adapter = AdapterListSensor()
        recyclerView.adapter = adapter
    }


}