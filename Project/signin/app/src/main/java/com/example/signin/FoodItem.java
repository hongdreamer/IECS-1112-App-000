package com.example.signin;
import java.io.Serializable;

public class FoodItem implements Serializable{

    private int imageId;
    private String foodName;
    private String foodPrice;
    private String foodDescription;

    public FoodItem(int imageId, String foodName, String foodPrice, String foodDescription) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
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
    public void setFoodDescription(String foodDescription) {this.foodDescription = foodDescription;}
    public String getFoodDescription(){return foodDescription;}
}
