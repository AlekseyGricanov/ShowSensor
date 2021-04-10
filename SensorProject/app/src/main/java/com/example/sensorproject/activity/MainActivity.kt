package com.arellomobile.mvp.sample.kotlin.activity

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.sample.kotlin.R
import com.arellomobile.mvp.sample.kotlin.adapter.AdapterListSensor
import com.arellomobile.mvp.sample.kotlin.interfaces.SensorItemList
import com.arellomobile.mvp.sample.kotlin.presenter.SensorPresenter
import com.arellomobile.mvp.sample.kotlin.view.SensorView

class MainActivity : MvpAppCompatActivity(), SensorView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var SensorPresenter: SensorPresenter

//    @ProvidePresenterTag(presenterClass = SensorPresenter::class, type = PresenterType.GLOBAL)
//    fun provideDialogPresenterTag(): String = "Hello"

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideDialogPresenter() = SensorPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sensor_list)
        SensorPresenter.PullSensor()

        //rootView.setOnClickListener { dialogPresenter.onShowDialogClick() }
    }

    override fun startSensor(listItems: MutableList<SensorItemList>) {
        val recyclerView: RecyclerView = findViewById(R.id.list)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val adapter = AdapterListSensor(listItems)
        recyclerView.adapter = adapter
    }

    override fun shortMessage(text: String) {
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    override fun endSensor() {
        TODO("Not yet implemented")
    }
}