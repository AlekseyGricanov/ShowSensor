package com.arellomobile.mvp.sample.kotlin.adapter

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.sample.kotlin.R
import com.arellomobile.mvp.sample.kotlin.interfaces.SensorItemList

open class AdapterListSensor(listItems: List<SensorItemList>) : RecyclerView.Adapter<AdapterListSensor.ViewHolder?>() {
    private val itemView: List<SensorItemList> = listItems

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameSensor: TextView = itemView.findViewById(R.id.name_sensor)
        var descSensor: TextView = itemView.findViewById(R.id.desc_sensor)
        var cordSensor: TextView = itemView.findViewById(R.id.cord_sensor)
        var statSensor: TextView = itemView.findViewById(R.id.stat_sensor)

        init {
            itemView.setOnClickListener {
                //Ссылка на расширенное представление
            }
        }
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_sensor_list, parent, false))
    }


    override fun getItemCount() = itemView.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: SensorItemList = itemView[position]
        holder.nameSensor.text = item.nameSensor
        holder.descSensor.text = item.descSensor
        holder.cordSensor.text = item.cordSensor
        holder.statSensor.text = item.statusSensor
    }
}