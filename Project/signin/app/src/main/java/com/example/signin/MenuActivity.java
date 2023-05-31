package com.example.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {

    private List<FoodItem> foods;
    private Button btnCheckCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // set the menu, which is displayed by a listview.
        ListView lvFoods = findViewById(R.id.lv_foods);
        foods = new ArrayList<>();
        foods.add(new FoodItem(R.drawable.chicken, "雞排", 65, "meal"));
        foods.add(new FoodItem(R.drawable.salt_chicken, "鹽酥雞", 55, "meal"));
        foods.add(new FoodItem(R.drawable.squid, "魷魚塊", 55, "meal"));
        foods.add(new FoodItem(R.drawable.fries, "薯條", 30, "meal"));
        foods.add(new FoodItem(R.drawable.sweet_no_spicy, "甜不辣", 15, "meal"));
        foods.add(new FoodItem(R.drawable.tofu, "百頁豆腐", 20, "meal"));
        foods.add(new FoodItem(R.drawable.pig_blood, "豬血糕", 25, "meal"));
        foods.add(new FoodItem(R.drawable.plant, "杏鮑菇", 25, "meal"));
        foods.add(new FoodItem(R.drawable.small_corn, "玉米筍", 25, "meal"));
        foods.add(new FoodItem(R.drawable.black_tea, "紅茶", 15, "drink"));
        foods.add(new FoodItem(R.drawable.green_tea, "綠茶", 15, "drink"));
        foods.add(new FoodItem(R.drawable.milk_tea, "奶茶", 25, "drink"));

        ListViewAdapter4Menu adapter = new ListViewAdapter4Menu(this, foods);
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
                if (Objects.equals(selectedItem.getFoodType(), "drink"))
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
        btnCheckCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculateTotalPrice() > 0) {
                    Intent intent = new Intent(MenuActivity.this, CartActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MenuActivity.this, "訂單為空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        updateCartButtonText();

        Button btnMenuBack = findViewById(R.id.btn_menu_back);
        btnMenuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateCartButtonText() {
        int totalPrice = calculateTotalPrice();
        String textBtnCheckCart = "購物車\t$" + totalPrice;
        btnCheckCart.setText(textBtnCheckCart);
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        Order order = Order.getInstance();
        List<FoodItem> orderItems = order.getOrder();
        for (FoodItem food : orderItems) {
            totalPrice += food.getFoodPrice() * food.getFoodQuantity();
        }
        return totalPrice;
    }

}
