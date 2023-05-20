package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkDetailActivity extends AppCompatActivity {
  private int amount = 0;
  private String foodName, foodType;
  private int imageId, foodPrice;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drink_detail);

    TextView titleTxt = findViewById(R.id.tv_drink_name);
    TextView feeTxt = findViewById(R.id.tv_drink_price);
    ImageView foodImage = findViewById(R.id.iv_drink_img);
    ImageView plusButton = findViewById(R.id.iv_drink_btn_plus);
    ImageView minusButton = findViewById(R.id.iv_drink_btn_minus);
    TextView amountTextView = findViewById(R.id.tv_drink_amount);
    Button addToCartButton = findViewById(R.id.btn_drink_add_to_cart);

    // activity setup according to what it is

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      FoodItem selectedFood = (FoodItem) bundle.getSerializable("foodItem");
      if (selectedFood != null) {
        imageId = selectedFood.getImageId();
        foodName = selectedFood.getFoodName();
        foodPrice = selectedFood.getFoodPrice();
        foodType = selectedFood.getFoodType();
        // Display the detailed information of the food item in the views
        titleTxt.setText(foodName);
        feeTxt.setText(String.valueOf(foodPrice));
        foodImage.setImageResource(imageId);
        // Set other views accordingly
      }
    }

    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        amount++;
        amountTextView.setText(String.valueOf(amount));
      }
    });

    minusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (amount > 0) {
          amount--;
          amountTextView.setText(String.valueOf(amount));
        }
      }
    });

    addToCartButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Create a new FoodItem with the relevant details
        FoodItem drinkItem = new FoodItem(imageId, foodName, foodPrice, foodType);
        // Add the drink to the order
        Order.getInstance().addToOrder(drinkItem);
        // Display a message or perform any additional actions
        Toast.makeText(DrinkDetailActivity.this, "Drink added to cart", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
