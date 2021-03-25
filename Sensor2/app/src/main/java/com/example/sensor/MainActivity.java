package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<RecyclerItem> listItems = new ArrayList<>();

        listItems.add(new RecyclerItem("Название", "Описание", "Кординаты", "Статус"));

        for (int i = 0; i < 10; i++) {
            listItems.add(new RecyclerItem("Name " + i, "CPRE" + i, "432, 324", "active"));
        }


        Adapter adapter = new Adapter(listItems, this);
//        View header = getLayoutInflater().inflate(R.layout.item_header, null);
//        recyclerView.addHeaderView(header);
        recyclerView.setAdapter(adapter);


//        TextView text = findViewById(R.id.name_sensor);
//        text.setText("SPCE");
//
//        ListView list = findViewById(R.id.listView);
//
//        // определяем строковый массив
//        final String[] catNames = new String[] {
//                "RUSE" + " 65.3213, 45.2312" + " Россия. Аляска" + " active",
//                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
//                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
//                "Китти", "Масяня", "Симба"
//        };
//
//        // используем адаптер данных
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, catNames);
//
//        list.setAdapter(adapter);
    }

    public void onClick(View view) {
    }
}