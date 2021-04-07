package com.example.sensor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensor.model.MainItemSensor;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<MainItemSensor> itemView;

    public Adapter(List<MainItemSensor> listItems, Context mContext) {
        this.itemView = listItems;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameSensor;
        public TextView descSensor;
        public TextView cordSensor;
        public TextView statSensor;

        public ViewHolder(View itemView) {
            super(itemView);

            nameSensor = itemView.findViewById(R.id.name_sensor);
            descSensor = itemView.findViewById(R.id.desc_sensor);
            cordSensor = itemView.findViewById(R.id.cord_sensor);
            statSensor = itemView.findViewById(R.id.stat_sensor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Ссылка на расширенное представление
                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sensor_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MainItemSensor item = itemView.get(position);
        holder.nameSensor.setText(item.getNameSensor());
        holder.descSensor.setText(item.getDescSensor());
        holder.cordSensor.setText(item.getCordSensor());
        holder.statSensor.setText(item.getStatusSensor());
    }

    @Override
    public int getItemCount() {
        return itemView.size();
    }
}
