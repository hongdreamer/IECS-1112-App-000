package com.example.signin;

public class Fooditem {

    private int imageId;
    private String foodName;
    private String foodPrice;

    public Fooditem(int imageId, String foodName, String foodPrice) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
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


}
