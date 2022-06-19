package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    ListView list;
    String[] devices = {"Планшеты", "Телефоны", "Компьютеры", "Ноутбуки"};
    String buffer  = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice,
                devices
        );
        list.setAdapter(adapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {
        });

    }
    public void onClick(View arg0) {
        //обнуляем буфер
        buffer = "";
        //вытаскиваем из листа нажатые элементы
        SparseBooleanArray sbArray = list.getCheckedItemPositions();
        //проходимся циклом по этим элементам
        for (int i = 0; i < sbArray.size(); i++) {
            //вытаскиваем ключ очередного элемента
            int key = sbArray.keyAt(i);
            //проверка ключа
            if (sbArray.get(key))
                //если ключ есть прибавляем к буферу текст элемента
                buffer += devices[key] + " ";
        }
        //выводим результат
        Toast.makeText(this, buffer, Toast.LENGTH_SHORT).show();
    }
}

