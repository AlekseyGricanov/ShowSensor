package com.example.sensorproject.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.sensorproject.R
import com.example.sensorproject.domain.models.SensorItemList
import java.util.*


open class AdapterListSensor(private val listener: OnClickListener) : RecyclerView.Adapter<AdapterListSensor.ViewHolder?>() {
    private val itemView: MutableList<SensorItemList> = LinkedList()

    fun setDate(newItemView: List<SensorItemList>) {
        itemView.clear()
        itemView.addAll(newItemView)

        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{

        private var idSensor: Int = -1
        private val nameSensor: TextView = itemView.findViewById(R.id.name_sensor)
        private val statSensor: ImageView = itemView.findViewById(R.id.stat_sensor)

        fun bind(model: SensorItemList) {

            idSensor = model.idSensor
            nameSensor.text = model.nameSensor
            when (model.statusSensor) {
                "1" -> statSensor.setImageResource(R.drawable.green_circle_100)
                "0" -> statSensor.setImageResource(R.drawable.red_circle_100)
                else -> statSensor.setImageResource(R.drawable.yellow_circle_100)
            }
            itemView.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            listener.onClickListener(idSensor)
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

    interface OnClickListener {
        fun onClickListener(idSensor: Int)
    }
}