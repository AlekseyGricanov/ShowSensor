package com.example.sensorproject.app.adapter

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sensorproject.R
import com.example.sensorproject.app.models.SensorItemList
import java.util.*

open class AdapterListSensor() : RecyclerView.Adapter<AdapterListSensor.ViewHolder?>() {
    //private val itemView: List<SensorItemList> = listItems
    private val itemView: MutableList<SensorItemList> = LinkedList()

    fun setDate(newItemView: List<SensorItemList>) {
        itemView.clear()
        itemView.addAll(newItemView)

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameSensor: TextView = itemView.findViewById(R.id.name_sensor)
        private val descSensor: TextView = itemView.findViewById(R.id.desc_sensor)
        private val cordSensor: TextView = itemView.findViewById(R.id.cord_sensor)
        private val statSensor: TextView = itemView.findViewById(R.id.stat_sensor)

        fun bind(model: SensorItemList) {
            nameSensor.text = model.nameSensor
            descSensor.text = model.descSensor
            cordSensor.text = model.cordSensor
            statSensor.text = model.statusSensor // todo: переделать под нормальный статус, а не текстовый
        }
    }

    @NonNull
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(R.layout.item_sensor_list, viewGroup, false))
    }


    override fun getItemCount(): Int {
        return itemView.count()
    }


    override fun onBindViewHolder(ViewHolder: ViewHolder, position: Int) {
        ViewHolder.bind(model = itemView[position])
    }
}