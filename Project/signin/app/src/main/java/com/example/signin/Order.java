package com.example.signin;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
  private static Order instance; // Singleton instance

  private List<FoodItem> order; // Changed to ArrayList<FoodItem>

  private Order() {
    order = new ArrayList<>();
  }

  // Get the instance of the Order object
  public static Order getInstance() {
    if (instance == null) {
      instance = new Order();
    }
    return instance;
  }

  public void addToOrder(FoodItem item) {
    Log.i("Order", "Food Ps: " + item.getFoodPs());
    boolean itemExists = false;
    for (FoodItem existingItem : order) {
      if (existingItem.getFoodName().equals(item.getFoodName()) &&
              existingItem.getFoodPs().equals(item.getFoodPs())) {
        // Item with the same name and options already exists in the order
        existingItem.setFoodQuantity(existingItem.getFoodQuantity() + item.getFoodQuantity());
        itemExists = true;
        break;
      }
    }

    if (!itemExists) {
      order.add(item);
    }
  }

  public void clear() {
    order.clear();
  }

  public void removeFromOrder(FoodItem item){
    order.remove(item);
  }

  // Add other methods as needed

  public List<FoodItem> getOrder() {
    return order;
  }
}
