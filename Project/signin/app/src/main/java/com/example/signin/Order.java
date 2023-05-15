package com.example.signin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Order {

  // By this setting, all the activity could share the same object.
  private static Order instance; // Singleton instance

  private List<FoodItem> order;

  private Order() {
    order = new ArrayList<FoodItem>();
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

  public void removeFromOrder(int idx){
    order.remove(idx);
  }

  public FoodItem getItem(int idx){
    return order.get(idx);
  }

}
