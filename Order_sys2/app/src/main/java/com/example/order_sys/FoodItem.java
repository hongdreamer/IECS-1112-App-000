package com.example.order_sys;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class FoodItem {

    private int imageId;
    private String foodName;
    private int foodPrice;

    private Button btnAdd;

    public FoodItem(int imageId, String foodName, int foodPrice, Button btnAdd){
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.btnAdd = btnAdd;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(FoodItem.this, FoodActivity.class);
                startActivity(intent);
            }
        });
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

}
