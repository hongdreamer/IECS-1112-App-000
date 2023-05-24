package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkDetailActivity extends AppCompatActivity {
  private int quantity = 0;
  private String foodName, foodType, foodPs;
  private int imageId, foodPrice;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drink_detail);

    TextView titleTxt = findViewById(R.id.tv_drink_name);
    TextView feeTxt = findViewById(R.id.tv_drink_price);
    ImageView foodImage = findViewById(R.id.iv_drink_img);
    Spinner temperatureSpinner = findViewById(R.id.sp_temperature);
    Spinner sugarSpinner = findViewById(R.id.sp_sugar);
    ImageView plusButton = findViewById(R.id.iv_drink_btn_plus);
    ImageView minusButton = findViewById(R.id.iv_drink_btn_minus);
    TextView amountTextView = findViewById(R.id.tv_drink_amount);
    Button addToCartButton = findViewById(R.id.btn_drink_add_to_cart);
    Button btnDrinkDetailBack = findViewById(R.id.btn_drink_detail_back);


    // activity setup according to what it is

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      FoodItem selectedFood = (FoodItem) bundle.getSerializable("foodItem");
      if (selectedFood != null) {
        imageId = selectedFood.getImageId();
        foodName = selectedFood.getFoodName();
        foodPrice = selectedFood.getFoodPrice();
        foodType = selectedFood.getFoodType();
        String priceText = "$" + foodPrice;
        // Display the detailed information of the food item in the views
        titleTxt.setText(foodName);
        feeTxt.setText(priceText);
        foodImage.setImageResource(imageId);
        // Set other views accordingly
      }
    }

    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        quantity++;
        amountTextView.setText(String.valueOf(quantity));
      }
    });

    minusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (quantity > 0) {
          quantity--;
          amountTextView.setText(String.valueOf(quantity));
        }
      }
    });

    addToCartButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String temperature = temperatureSpinner.getSelectedItem().toString();
        String sugar = sugarSpinner.getSelectedItem().toString();
        foodPs = temperature + "；" + sugar + "；";
        if(quantity > 0){
          // Create a new FoodItem with the relevant details
          FoodItem drinkItem = new FoodItem(imageId, foodName, foodPrice, foodType, quantity, foodPs);
          // Add the drink to the order
          Order.getInstance().addToOrder(drinkItem);
          // Display a message or perform any additional actions
          Toast.makeText(DrinkDetailActivity.this, "Drink added to cart", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(DrinkDetailActivity.this, MenuActivity.class);
          startActivity(intent);
          finish();
        }
        else
          Toast.makeText(DrinkDetailActivity.this, "The quantity is 0.", Toast.LENGTH_SHORT).show();
      }
    });

    btnDrinkDetailBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override
  public void onBackPressed() {
    // Disable the back button
    // Remove the super call to disable the default back button behavior
    Intent intent = new Intent(DrinkDetailActivity.this, MenuActivity.class);
    startActivity(intent);
    finish();
  }
}
