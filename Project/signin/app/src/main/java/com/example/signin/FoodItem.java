package com.example.signin;
import java.io.Serializable;

public class FoodItem implements Serializable{

    private int imageId;
    private String foodName;
    private int foodPrice;

    // drink or meal
    // it would determine what activity should be opened. (MealDetailActivity, DrinkDetailActivity)
    private String foodType;

    // customized food
    private String ps;
    private int quantity;

    public FoodItem(int imageId, String foodName, int foodPrice, String foodType) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        // drink or meal.
        this.foodType = foodType;
        // ice or not...etc.
        this.ps = "";
        // the quantity of the food you want to order.
        this.quantity = 0;
    }
    public FoodItem(int imageId, String foodName, int foodPrice, String foodType, int quantity, String ps) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        // drink or meal.
        this.foodType = foodType;
        // ice or not...etc.
        this.ps = ps;
        // the quantity of the food you want to order.
        this.quantity = quantity;
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
    public void setFoodType(String foodDescription) {this.foodType = foodDescription;}
    public String getFoodType(){return foodType;}
    public String getFoodPs() {
        return ps;
    }
    public void setFoodPs(String ps) {
        this.ps = ps;
    }
    public int getFoodQuantity() {
        return quantity;
    }
    public void setFoodQuantity(int quantity) {
        this.quantity = quantity;
    }
}
