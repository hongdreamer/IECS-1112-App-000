package com.example.signin;
import java.io.Serializable;

public class FoodItem implements Serializable{

    private int imageId;
    private String foodName;
    private String foodPrice;

    // drink or mea
    // it would determine what activity should be opened. (MealDetailActivity, DrinkDetailActivity)
    private String foodType;

    // customized food
    private String ps;
    private int quantity;

    public FoodItem(int imageId, String foodName, String foodPrice, String foodType) {
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
    public String getPs() {
        return ps;
    }
    public void setPs(String ps) {
        this.ps = ps;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
