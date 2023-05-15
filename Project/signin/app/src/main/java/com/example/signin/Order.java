package com.example.signin;

import java.util.Map;
import java.util.HashMap;

public class Order {

  // By this setting, all the activity could share the same object.
  private static Order instance; // Singleton instance

  private Map<FoodItem, Integer> order;

  private Order() {
    order = new HashMap<FoodItem, Integer>();
  }

  // Get the instance of the Order object
  public static Order getInstance() {
    if (instance == null) {
      instance = new Order();
    }
    return instance;
  }

  public void addToOrder(FoodItem item, int quantity) {
    order.put(item, quantity);
  }

  public void removeFromOrder(FoodItem item, int quantity){
    order.remove(item);
  }

}
