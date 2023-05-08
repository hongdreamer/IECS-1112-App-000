package com.example.signin;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView titleTxt,feeTxt,descriptionTxt,numberTxt;
    private ImageView plusBtn,minusBtn,foodImage;
    private Button addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initView();

        // Get the passed data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            FoodItem selectedFood = (FoodItem) bundle.getSerializable("foodItem");
            if (selectedFood != null) {
                // Display the detailed information of the food item in the views
                titleTxt.setText(selectedFood.getFoodName());
                feeTxt.setText(selectedFood.getFoodPrice());
                descriptionTxt.setText(selectedFood.getFoodType());
                foodImage.setImageResource(selectedFood.getImageId());
                // Set other views accordingly
            }
        }
    }


    private void initView() {
        // specified by the previous page
        titleTxt = findViewById(R.id.tv_title);
        feeTxt = findViewById(R.id.tv_price);
        descriptionTxt = findViewById(R.id.tv_description);
        foodImage = findViewById(R.id.iv_foodImage);
        // specified by the order
        numberTxt = findViewById(R.id.tv_amount);

        // the widgets which could be operated in this page,
        // and we use it to interact with the order
        plusBtn = findViewById(R.id.iv_btn_plus);
        minusBtn = findViewById(R.id.iv_btn_minus);
        addToCartBtn = findViewById(R.id.btn_add_to_cart);

        // Plus button click listener
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add your logic for plus button click event
                //Toast.makeText(ShowDetailActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
            }
        });

        // Minus button click listener
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add your logic for minus button click event
                //Toast.makeText(ShowDetailActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
            }
        });

        // Add to cart button click listener
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add your logic for add to cart button click event
                //Toast.makeText(ShowDetailActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
            }
        });

    }


}