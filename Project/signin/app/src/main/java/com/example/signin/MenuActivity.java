package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView lvFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // setup the menu, which is displayed by a listview.
        lvFoods = findViewById(R.id.lv_foods);
        List<FoodItem> foods = new ArrayList<FoodItem>();
        foods.add(new FoodItem(R.drawable.food1,"可樂","50", "drink"));
        foods.add(new FoodItem(R.drawable.food2,"雞塊","100", "snack"));
        foods.add(new FoodItem(R.drawable.food3,"薯條","20", "snack"));
        foods.add(new FoodItem(R.drawable.food4,"漢堡","30", "meal"));

        ListViewAdapter adapter = new ListViewAdapter(this,foods);
        lvFoods.setAdapter(adapter);

        // deal with the click events of the listview widget.
        lvFoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodItem selectedItem = foods.get(position);

                // Create a bundle object, and add the details of the selected item to the bundle

                Bundle bundle = new Bundle();

                /* These statements are work, but I think deliver an object would be better.
                bundle.putInt("imageId", selectedItem.getImageId());
                bundle.putString("foodName", selectedItem.getFoodName());
                bundle.putString("foodPrice", selectedItem.getFoodPrice());
                bundle.putString("foodDescription", selectedItem.getFoodDescription());
                */

                bundle.putSerializable("foodItem", selectedItem);

                // Create an Intent object, specify the current and target activities
                Intent intent = new Intent(MenuActivity.this, ShowDetailActivity.class);
                intent.putExtras(bundle);

                // Start the new activity
                startActivity(intent);
            }
        });





    }
}