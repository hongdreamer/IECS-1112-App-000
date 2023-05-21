package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MealDetailActivity extends AppCompatActivity {
  private int quantity = 0;
  private String foodName, foodType, foodPs;
  private int imageId, foodPrice;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_meal_detail);

    TextView titleTxt = findViewById(R.id.tv_meal_name);
    TextView feeTxt = findViewById(R.id.tv_meal_price);
    ImageView foodImage = findViewById(R.id.iv_meal_img);
    Spinner flavorSpinner = findViewById(R.id.sp_flavor);
    Spinner spicinessSpinner = findViewById(R.id.sp_spiciness);
    ImageView plusButton = findViewById(R.id.iv_meal_btn_plus);
    ImageView minusButton = findViewById(R.id.iv_meal_btn_minus);
    TextView amountTextView = findViewById(R.id.tv_meal_amount);
    Button addToCartButton = findViewById(R.id.btn_meal_add_to_cart);


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
        String flavor = flavorSpinner.getSelectedItem().toString();
        String spiciness = spicinessSpinner.getSelectedItem().toString();
        foodPs = flavor + "；" + spiciness + "；";
        if(quantity > 0){
          // Create a new FoodItem with the relevant details
          FoodItem mealItem = new FoodItem(imageId, foodName, foodPrice, foodType, quantity, foodPs);
          // Add the drink to the order
          Order.getInstance().addToOrder(mealItem);
          // Display a message or perform any additional actions
          Toast.makeText(MealDetailActivity.this, "Meal added to cart", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(MealDetailActivity.this, MenuActivity.class);
          startActivity(intent);
          finish();
        }
        else
          Toast.makeText(MealDetailActivity.this, "The quantity is 0.", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public void onBackPressed() {
    // Disable the back button
    // Remove the super call to disable the default back button behavior
    Intent intent = new Intent(MealDetailActivity.this, MenuActivity.class);
    startActivity(intent);
    finish();
  }
}