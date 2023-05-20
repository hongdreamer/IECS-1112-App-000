package com.example.signin;

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
    order.add(item);
  }

  public void removeFromOrder(FoodItem item){
    order.remove(item);
  }

  // Add other methods as needed

  public List<FoodItem> getOrder() {
    return order;
  }
}
