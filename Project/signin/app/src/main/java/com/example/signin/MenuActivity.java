package com.example.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
        foods.add(new FoodItem(R.drawable.food1, "可樂", 50, "drink"));
        foods.add(new FoodItem(R.drawable.food2, "雞塊", 100, "meal"));
        foods.add(new FoodItem(R.drawable.food3, "薯條", 20, "meal"));
        foods.add(new FoodItem(R.drawable.food4, "漢堡", 30, "meal"));

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
                Intent intent = new Intent(MenuActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
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
