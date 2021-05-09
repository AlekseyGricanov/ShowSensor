package com.example.sensorproject.app.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.sensorproject.R
import com.example.sensorproject.domain.models.SensorList
import java.util.*

open class AdapterSensor() : RecyclerView.Adapter<AdapterSensor.ViewHolder?>() {
    private val itemView: MutableList<SensorList> = LinkedList()

    fun setDate(newItemView: List<SensorList>) {
        itemView.clear()
        itemView.addAll(newItemView)

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id: TextView             = itemView.findViewById(R.id.id_sensor_main)
        private val timeLastUpdate: TextView = itemView.findViewById(R.id.l_u_date_sensor_main)
        private val perStorage: TextView     = itemView.findViewById(R.id.stor_sensor_main)
        private val timeService: TextView    = itemView.findViewById(R.id.service_sensor)
        private val idSensor: TextView       = itemView.findViewById(R.id.id_sensor_item)

        fun bind(model: SensorList) {
            Log.i(TAG, model.id.toString())
            id.text             = model.id.toString()
            timeLastUpdate.text = model.timeLastUpdate
            perStorage.text     = model.perStorage.toString()
            timeService.text    = model.timeService
            idSensor.text       = model.idSensor.toString()
        }
    }

    @NonNull
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_activity_sensor, viewGroup, false))
    }


    override fun getItemCount(): Int {
        return itemView.count()
    }


    override fun onBindViewHolder(ViewHolder: ViewHolder, position: Int) {
        ViewHolder.bind(model = itemView[position])
    }
}