package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class product_list extends AppCompatActivity {

    private ListView lvFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        lvFoods = findViewById(R.id.lv_foods);
        List<Fooditem> foods = new ArrayList<Fooditem>();
        foods.add(new Fooditem(R.drawable.food1,"可樂","50"));
        foods.add(new Fooditem(R.drawable.food2,"雞塊","100"));
        foods.add(new Fooditem(R.drawable.food3,"薯條","20"));
        foods.add(new Fooditem(R.drawable.food4,"漢堡","30"));

        ListViewAdapter adapter = new ListViewAdapter(this,foods);
        lvFoods.setAdapter(adapter);






    }
}