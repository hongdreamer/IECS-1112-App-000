package com.example.signin;
import java.io.Serializable;

public class FoodItem implements Serializable{

    private int imageId;
    private String foodName;
    private String foodPrice;

    // drink or meal or snack
    // it would determine what activity should be opened. (MealDetailActivity, DrinkDetailActivity, snackDetailActivity)
    private String foodType;

    public FoodItem(int imageId, String foodName, String foodPrice, String foodType) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
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
    public String getFoodPrice() {
        return foodPrice;
    }
    public void setFoodType(String foodDescription) {this.foodType = foodDescription;}
    public String getFoodType(){return foodType;}
}
