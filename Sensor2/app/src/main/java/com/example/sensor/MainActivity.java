package com.example.sensor;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensor.model.MainItemSensor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<MainItemSensor> listItems = new ArrayList<>();

        listItems.add(new MainItemSensor("Название", "Описание", "Кординаты", "Статус"));

        for (int i = 0; i < 10; i++) {
            listItems.add(new MainItemSensor("Name " + i, "CPRE" + i, "432, 324", "active"));
        }


        Adapter adapter = new Adapter(listItems, this);
        recyclerView.setAdapter(adapter);

    }

    public void onClick(View view) {
    }
}