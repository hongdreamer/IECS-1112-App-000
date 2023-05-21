package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView lvFoods;
    private Button btnCheckCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // set the menu, which is displayed by a listview.
        lvFoods = findViewById(R.id.lv_foods);
        List<FoodItem> foods = new ArrayList<FoodItem>();
        foods.add(new FoodItem(R.drawable.food1,"可樂",50, "drink"));
        foods.add(new FoodItem(R.drawable.food2,"雞塊",100, "meal"));
        foods.add(new FoodItem(R.drawable.food3,"薯條",20, "meal"));
        foods.add(new FoodItem(R.drawable.food4,"漢堡",30, "meal"));

        ListViewAdapter4Menu adapter = new ListViewAdapter4Menu(this,foods);
        lvFoods.setAdapter(adapter);

        // deal with the click events of the listview widget.
        lvFoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodItem selectedItem = foods.get(position);

                // Create a bundle object, and add the details of the selected item to the bundle
                Bundle bundle = new Bundle();
                bundle.putSerializable("foodItem", selectedItem);
                // Create an Intent object, specify target activity
                Intent intent;
                if(selectedItem.getFoodType() == "drink")
                    // drink
                    intent = new Intent(MenuActivity.this, DrinkDetailActivity.class);
                else
                    // meal
                    intent = new Intent(MenuActivity.this, MealDetailActivity.class);

                intent.putExtras(bundle);
                // Start the new activity
                startActivity(intent);
                finish();
            }
        });

        // go checking the cart.
        // page switching.
        btnCheckCart = findViewById(R.id.btn_check_cart);
        Button.OnClickListener listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        };
        btnCheckCart.setOnClickListener(listener);
    }

    @Override
    public void onBackPressed() {
        // Disable the back button
        // Remove the super call to disable the default back button behavior
        Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}